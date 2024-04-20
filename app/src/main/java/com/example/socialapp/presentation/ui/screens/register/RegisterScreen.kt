package com.example.socialapp.presentation.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialapp.presentation.ui.screens.components.SignToolbarComponents
import com.example.socialapp.presentation.theme.PurpleBlack
import kotlinx.coroutines.flow.StateFlow

@Composable
fun RegisterScreen(
    onInteraction: (RegisterScreenInteraction) -> Unit,
    modifier: Modifier = Modifier,
    uiStateFlow: StateFlow<RegisterUiState>,

//    navigateUpFlow: StateFlow<Unit>
) {

    val uiState: RegisterUiState = uiStateFlow.collectAsState().value
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(PurpleBlack)
            .padding(start = 20.dp)
    ) {
        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.Center
        ) {
            SignToolbarComponents(
                onIconClick = { onInteraction(RegisterScreenInteraction.OnNavigateUp) }
            )
            Spacer(modifier = Modifier.height(40.dp))
            UserTextFieldBlock(
                text = uiState.userFirstName,
                onValueChanged = {
                    onInteraction(RegisterScreenInteraction.OnUserFirstNameChanged(it))
                },
            )
            UserTextFieldBlock(
                text = uiState.userLastName,
                onValueChanged = {
                    onInteraction(RegisterScreenInteraction.OnUserLastNameChanged(it))
                },
            )
            UserTextFieldBlock(
                text = uiState.userEmail,
                onValueChanged = {
                    onInteraction(RegisterScreenInteraction.OnUserEmailCnaged(it))
                },
            )
            UserTextFieldBlock(
                text = uiState.userPassword,
                onValueChanged = {
                    onInteraction(RegisterScreenInteraction.OnUserPasswordChanged(it))
                },
            )
            Button(onClick = { onInteraction(RegisterScreenInteraction.OnRedisterButtonCLick) }) {
                Text(text = "Register")
            }
        }
    }
}

@Composable
fun UserTextFieldBlock(
    modifier: Modifier = Modifier,
    text: String,
    onValueChanged: (String) -> Unit,
    userPassword: Boolean = false
) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChanged
    )
}

//@Preview
//@Composable
//fun RegisterScreenPreview() {
//    MaterialTheme {
//        RegisterScreen(
//            onInteraction = {
//            },
////            SharedFlow = MutableSharedFlow(Unit)
//        )
//    }
//}