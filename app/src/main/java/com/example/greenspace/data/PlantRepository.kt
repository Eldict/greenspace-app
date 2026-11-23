package com.example.greenspace.data

import kotlinx.coroutines.flow.Flow

// Middle layer between the screens and the DAO. Screens never call the DAO directly.
class PlantRepository(private val plantDao: PlantDao) {

    // The user's plants. Flow sends a new list whenever the table changes.
    val allMyPlants: Flow<List<MyPlant>> = plantDao.getAllMyPlants()

    // Runs in the background because these are suspend functions.
    val allPlantTypes: Flow<List<PlantType>> = plantDao.getAllPlantTypes()

    suspend fun getMyPlant(plantId: Int) = plantDao.getMyPlant(plantId)

    suspend fun addMyPlant(myPlant: MyPlant) = plantDao.insertMyPlant(myPlant)

    suspend fun updateLastWateredDate(plantId: Int, newDate: String) =
        plantDao.updateLastWateredDate(plantId, newDate)
}