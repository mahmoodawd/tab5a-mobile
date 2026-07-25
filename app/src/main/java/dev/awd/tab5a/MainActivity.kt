package dev.awd.tab5a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.awd.tab5a.ui.common.MealDetailsScreen
import dev.awd.tab5a.ui.common.sampleMeals
import dev.awd.tab5a.ui.theme.Tab5aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Tab5aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MealDetailsScreen(
                        meal = sampleMeals.random(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

