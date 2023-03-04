package com.lihan.jetpackcomposeanimationpractice.animation.presentation.drawer

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Animation",
            fontSize = 64.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun DrawerBody(
    items : List<String>,
    onItemClicked :(String)->Unit
) {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ){
        items(items){ itemName ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        border = BorderStroke(2.dp, Color.Black),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clip(
                        RoundedCornerShape(8.dp)
                    )
                    .clickable { onItemClicked(itemName) },
            ){
                Text(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(16.dp)
                    ,
                    text = itemName,
                    fontSize = 14.sp
                )
            }
        }
    }
}