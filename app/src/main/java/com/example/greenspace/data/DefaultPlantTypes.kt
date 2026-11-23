package com.example.greenspace.data

// The 10 built-in indoor plants. Inserted into the database the first time the app opens.
val defaultPlantTypes = listOf(
    PlantType(name = "Jade plant", waterEveryDays = 14, lightNeed = "High", imageName = "jade_plant"),
    PlantType(name = "Spider plant", waterEveryDays = 7, lightNeed = "Medium", imageName = "spider_plant"),
    PlantType(name = "Yucca", waterEveryDays = 14, lightNeed = "High", imageName = "yucca"),
    PlantType(name = "Peace lily", waterEveryDays = 7, lightNeed = "Low", imageName = "peace_lily"),
    PlantType(name = "Cyclamen", waterEveryDays = 4, lightNeed = "Medium", imageName = "cyclamen"),
    PlantType(name = "Snake plant", waterEveryDays = 14, lightNeed = "Low", imageName = "snake_plant"),
    PlantType(name = "Aloe vera", waterEveryDays = 14, lightNeed = "High", imageName = "aloe_vera"),
    PlantType(name = "Pothos", waterEveryDays = 7, lightNeed = "Low", imageName = "pothos"),
    PlantType(name = "Rubber plant", waterEveryDays = 10, lightNeed = "Medium", imageName = "rubber_plant"),
    PlantType(name = "Monstera", waterEveryDays = 7, lightNeed = "Medium", imageName = "monstera")
)