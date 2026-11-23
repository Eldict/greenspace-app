package com.example.greenspace.data

import androidx.room.Entity
import androidx.room.PrimaryKey

// One row of the built-in plant list. Each field is a column in the table.
@Entity(tableName = "plant_type")
data class PlantType(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val waterEveryDays: Int,
    val lightNeed: String,
    val imageName: String
)