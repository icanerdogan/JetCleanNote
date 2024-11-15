package com.plcoding.cleanarchitecturenoteapp.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.plcoding.cleanarchitecturenoteapp.ui.view.edit.AddEditNoteScreen
import com.plcoding.cleanarchitecturenoteapp.ui.view.list.NoteListScreen

@ExperimentalAnimationApi
@Composable
fun NoteNavigation(modifier: Modifier) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = NoteScreen.NotesScreen.route
    ) {
        composable(route = NoteScreen.NotesScreen.route) {
            NoteListScreen(navController = navController)
        }
        composable(
            route = NoteScreen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(
                    name = "noteColor"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                },
            )
        ) {
            val color = it.arguments?.getInt("noteColor") ?: -1
            AddEditNoteScreen(
                navController = navController,
                noteColor = color
            )
        }
    }
}