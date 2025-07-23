package com.example.note_apk.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.note_apk.feature_note.presentation.add_edit_note.AddEditNoteScreen
import com.example.note_apk.feature_note.presentation.notes.NotesScreen
import com.example.note_apk.feature_note.presentation.util.Screen
import com.example.note_apk.ui.theme.Note_apkTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Note_apkTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Screen.NotesScreen.route
                        ) {
                            composable(route = Screen.NotesScreen.route) {
                                NotesScreen(navController = navController)
                            }
                            composable(
                                route = Screen.AddEditNoteScreen.route +
                                        "?noteId={noteId}&noteColor={noteColor}",
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
                }
            }
        }
    }
}





//@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    @ExperimentalAnimationApi
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            CleanArchitectureNoteAppTheme {
//                Surface(
//                    color = MaterialTheme.colors.background
//                ) {
//                    val navController = rememberNavController()
//                    NavHost(
//                        navController = navController,
//                        startDestination = Screen.NotesScreen.route
//                    ) {
//                        composable(route = Screen.NotesScreen.route) {
//                            NotesScreen(navController = navController)
//                        }
//                        composable(
//                            route = Screen.AddEditNoteScreen.route +
//                                    "?noteId={noteId}&noteColor={noteColor}",
//                            arguments = listOf(
//                                navArgument(
//                                    name = "noteId"
//                                ) {
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                },
//                                navArgument(
//                                    name = "noteColor"
//                                ) {
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                },
//                            )
//                        ) {
//                            val color = it.arguments?.getInt("noteColor") ?: -1
//                            AddEditNoteScreen(
//                                navController = navController,
//                                noteColor = color
//                            )
//                        }
//                    }
//                }
//            }
//        }
//    }
//}