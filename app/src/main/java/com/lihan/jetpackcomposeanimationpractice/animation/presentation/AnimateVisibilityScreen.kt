package com.lihan.jetpackcomposeanimationpractice.animation.presentation

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateVisibilityScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        var isShow by remember{
            mutableStateOf(false)
        }
        Button(onClick = {
            isShow = !isShow
        }) {
            Text(text = "Click")
        }
        AnimatedVisibility(
            visible = isShow,
            enter = slideInVertically() + expandVertically(expandFrom = Alignment.Top),
            exit = slideOutVertically()+ shrinkVertically(shrinkTowards = Alignment.Bottom),
        ) {
            Box(modifier = Modifier
                .padding(20.dp)
                .size(150.dp)
                .background(Color.Yellow)
            )
        }

    }
}