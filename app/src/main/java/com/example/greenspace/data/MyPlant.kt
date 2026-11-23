package com.example.greenspace.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

// One plant the user owns. plantTypeId points at a row in PlantType.
@Entity(
    tableName = "my_plant",
    foreignKeys = [
        ForeignKey(
            entity = PlantType::class,
            parentColumns = ["id"],
            childColumns = ["plantTypeId"]
        )
    ],
    indices = [Index("plantTypeId")]
)
data class MyPlant(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nickname: String,
    val photoUri: String?,
    val lastWateredDate: String,
    val plantTypeId: Int
)