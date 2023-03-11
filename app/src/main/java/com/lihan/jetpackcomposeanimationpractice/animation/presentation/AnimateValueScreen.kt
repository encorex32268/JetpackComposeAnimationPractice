package com.lihan.jetpackcomposeanimationpractice.animation.presentation

import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateValueScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        var isShow by remember{
            mutableStateOf(false)
        }
        val radius by animateIntAsState(
            targetValue = if (isShow) 50 else 20,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 500,
                easing = FastOutLinearInEasing
            )
        )
        Button(onClick = {
            isShow = !isShow
        }) {
            Text(text = "Click")
        }

        Box(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(radius))
                .background(Color.Green)

        )


    }
}