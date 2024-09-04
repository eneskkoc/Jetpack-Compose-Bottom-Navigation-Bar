package com.example.bottomnavigationbarjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bottomnavigationbarjetpack.ui.theme.BottomNavigationBarJetpackTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationBarJetpackTheme {
                MainScreen()
            }
        }
    }
}
