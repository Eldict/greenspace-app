package com.example.greenspace.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.greenspace.data.MyPlant
import com.example.greenspace.data.PlantType
import java.time.LocalDate
import java.time.temporal.ChronoUnit

// Days left until the plant needs water. A negative number means overdue.
fun daysUntilWatering(lastWateredDate: String, waterEveryDays: Int): Long {
    val lastWatered = LocalDate.parse(lastWateredDate)
    val daysSinceWatered = ChronoUnit.DAYS.between(lastWatered, LocalDate.now())
    return waterEveryDays - daysSinceWatered
}

// Turns the days left into a sentence, so the state is not shown by colour alone.
fun wateringMessage(daysLeft: Long): String {
    return when {
        daysLeft > 1 -> "Water in $daysLeft days"
        daysLeft == 1L -> "Water tomorrow"
        daysLeft == 0L -> "Water today"
        daysLeft == -1L -> "Overdue by 1 day"
        else -> "Overdue by ${-daysLeft} days"
    }
}

// One plant on the Home grid.
@Composable
fun PlantCard(
    myPlant: MyPlant,
    plantType: PlantType?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        // Picture area: shows the first letter until real photos are added.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = myPlant.nickname.take(1).uppercase(),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = myPlant.nickname,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = plantType?.name ?: "Unknown plant",
                style = MaterialTheme.typography.bodyMedium
            )
            if (plantType != null) {
                val daysLeft = daysUntilWatering(myPlant.lastWateredDate, plantType.waterEveryDays)
                Text(
                    text = wateringMessage(daysLeft),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}