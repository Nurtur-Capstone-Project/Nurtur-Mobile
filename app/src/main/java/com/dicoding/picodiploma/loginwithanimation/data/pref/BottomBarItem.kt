package com.dicoding.picodiploma.loginwithanimation.data.pref

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.dicoding.picodiploma.loginwithanimation.ui.navigation.Screen

data class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
