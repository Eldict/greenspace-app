package com.example.greenspace.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// The main Room database. Lists the tables and gives out the DAO.
@Database(
    entities = [PlantType::class, MyPlant::class],
    version = 1,
    exportSchema = false
)
abstract class PlantDatabase : RoomDatabase() {

    // Room writes the code for this function.
    abstract fun plantDao(): PlantDao

    companion object {
        // Holds the one and only database, so it is built once.
        @Volatile
        private var instance: PlantDatabase? = null

        fun build(context: Context): PlantDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    PlantDatabase::class.java,
                    "plant_database"
                ).addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            instance?.plantDao()?.insertPlantTypes(defaultPlantTypes)
                        }
                    }
                }).build().also { instance = it }
            }
        }
    }
}