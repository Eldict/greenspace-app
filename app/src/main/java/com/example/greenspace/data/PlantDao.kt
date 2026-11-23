package com.example.greenspace.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// The questions and actions the app can use on the database.
@Dao
interface PlantDao {

    // All plant types, for the "pick your plant" pictures.
    @Query("SELECT * FROM plant_type")
    fun getAllPlantTypes(): Flow<List<PlantType>>

    // How many plant types exist, used to fill the list only once.
    @Query("SELECT COUNT(*) FROM plant_type")
    suspend fun countPlantTypes(): Int

    // Adds many plant types at once.
    @Insert
    suspend fun insertPlantTypes(plantTypes: List<PlantType>)

    // All of the user's plants. Flow updates the Home screen by itself.
    @Query("SELECT * FROM my_plant")
    fun getAllMyPlants(): Flow<List<MyPlant>>

    // One plant by its id, for the details screen.
    @Query("SELECT * FROM my_plant WHERE id = :plantId")
    suspend fun getMyPlant(plantId: Int): MyPlant?

    // Adds one plant the user owns.
    @Insert
    suspend fun insertMyPlant(myPlant: MyPlant)

    // Saves a new "last watered" date for one plant.
    @Query("UPDATE my_plant SET lastWateredDate = :newDate WHERE id = :plantId")
    suspend fun updateLastWateredDate(plantId: Int, newDate: String)
}