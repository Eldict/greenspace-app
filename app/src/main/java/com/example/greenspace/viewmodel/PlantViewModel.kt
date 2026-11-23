package com.example.greenspace.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.greenspace.data.MyPlant
import com.example.greenspace.data.PlantRepository
import com.example.greenspace.data.PlantType
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// Holds the data the screens show and passes actions to the repository.
class PlantViewModel(private val repository: PlantRepository) : ViewModel() {

    // The user's plants, as a StateFlow so Compose can show them.
    val myPlants: StateFlow<List<MyPlant>> = repository.allMyPlants
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // The built-in plant types, for the "pick your plant" pictures.
    val plantTypes: StateFlow<List<PlantType>> = repository.allPlantTypes
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun addPlant(myPlant: MyPlant) {
        viewModelScope.launch { repository.addMyPlant(myPlant) }
    }

    fun markWatered(plantId: Int, newDate: String) {
        viewModelScope.launch { repository.updateLastWateredDate(plantId, newDate) }
    }
}

// Builds the ViewModel, because it needs the repository passed in.
class PlantViewModelFactory(private val repository: PlantRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return PlantViewModel(repository) as T
    }
}