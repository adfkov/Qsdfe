package com.example.week07.example5.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.unit.dp

@Composable
fun Favorites() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        var counter by rememberSaveable {
            mutableStateOf(0)
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Text(text = "ㅇㅇㅇ")
            }
        }
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorites",
                    tint = Color.Blue,
                    modifier = Modifier
                        .size(150.dp)
                        .align(Alignment.Center)
                )


}