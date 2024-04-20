package com.example.socialapp.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.socialapp.presentation.theme.SocialAppTheme
import com.example.socialapp.presentation.ui.screens.register.RegisterScreen
import com.example.socialapp.presentation.ui.screens.register.RegisterScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialAppTheme {
                // A surface container using the 'background' color from the theme
                val viewModel: RegisterScreenViewModel = hiltViewModel()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterScreen(
                        onInteraction = viewModel::onInteraction,
                        uiStateFlow = viewModel.uiState)
                }
            }
        }
    }
}
