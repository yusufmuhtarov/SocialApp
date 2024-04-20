package com.example.socialapp.presentation.ui.screens.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SocialTextFieldComponent(
    modifier: Modifier = Modifier,
    hintText: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = "",
        onValueChange = {

        },
    )
}


@Preview
@Composable
fun SocialTextFieldComponentPreview() {

}