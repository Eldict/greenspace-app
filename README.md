# GreenSpace

GreenSpace is an Android app for looking after indoor plants. It helps people remember when to water each plant and whether it is sitting in the right amount of light. It is free and works offline.

I made it for my Programming for Mobile Devices course. It is built with Kotlin, Jetpack Compose and Material 3.

## The problem

A lot of people buy an indoor plant and lose it within a few weeks because they forget to water it or leave it in the wrong spot. Most plant apps cost money or need an account, which puts beginners off.

## What the app does

- Shows your plants on a home screen as a grid of cards.
- Lets you add a plant by taking a photo and picking the plant type from pictures, so you do not need to know its name.
- Shows each plant's details: how often to water it, how much light it needs and when it was last watered.
- Checks the light in the room using the phone's light sensor.
- Sends a daily watering reminder.

## Database

The app uses a Room database with two tables.

**PlantType** (the list of known indoor plants, filled in when the app first opens)

| Column | Meaning |
| --- | --- |
| id | unique number |
| name | plant name |
| waterEveryDays | how many days between watering |
| lightNeed | for example full shade or moderate |
| imageName | name of the picture for this plant |

**MyPlant** (the plants the user owns)

| Column | Meaning |
| --- | --- |
| id | unique number |
| nickname | name the user gives the plant |
| photoUri | the user's own photo |
| lastWateredDate | date it was last watered |
| plantTypeId | links to PlantType (foreign key) |

One plant type can have many of the user's plants.

## Tech

- Kotlin
- Jetpack Compose with Material 3
- Room database
- ViewModel
- WorkManager (daily reminder)
- Light sensor and camera
- Minimum Android version: 35

## Status

Work in progress. The database and the main screens are being built first. The light check, camera and reminder come after.
