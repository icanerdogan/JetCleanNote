package com.plcoding.cleanarchitecturenoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.cleanarchitecturenoteapp.ui.navigation.NoteNavigation
import com.plcoding.cleanarchitecturenoteapp.ui.theme.CleanArchitectureNoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureNoteAppTheme {
                Scaffold (
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    NoteNavigation(
                        modifier = Modifier.fillMaxSize().padding(paddingValues)
                    )
                }
            }
        }
    }
}