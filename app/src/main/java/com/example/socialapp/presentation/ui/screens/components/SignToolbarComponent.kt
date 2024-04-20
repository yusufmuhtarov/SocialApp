package com.example.socialapp.presentation.ui.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.socialapp.R
import com.example.socialapp.presentation.theme.PurpleBlack

@Composable
fun SignToolbarComponents(
    modifier: Modifier = Modifier,
    onIconClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .background(PurpleBlack)
            .fillMaxWidth()
            .height(50.dp)
            .padding(top = 10.dp,)

    ) {
        IconButton(onClick = { onIconClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.left),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
@Preview
fun SignToolbarComponentPreview() {
    MaterialTheme {
        SignToolbarComponents(
            onIconClick = {

            }
        )
    }
}