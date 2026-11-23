package com.example.greenspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greenspace.ui.theme.GreenSpaceTheme

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.greenspace.data.PlantDatabase
import com.example.greenspace.data.PlantRepository
import com.example.greenspace.viewmodel.PlantViewModel
import com.example.greenspace.viewmodel.PlantViewModelFactory
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.greenspace.ui.screens.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Build the chain: database, then repository, then the factory.
        val database = PlantDatabase.build(applicationContext)
        val repository = PlantRepository(database.plantDao())
        val viewModelFactory = PlantViewModelFactory(repository)

        setContent {
            val plantViewModel: PlantViewModel = viewModel(factory = viewModelFactory)
            GreenSpaceTheme {
                val myPlants by plantViewModel.myPlants.collectAsState()
                HomeScreen(
                    myPlants = myPlants,
                    onAddPlantClick = { }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreenSpaceTheme {
        Greeting("Android")
    }
}