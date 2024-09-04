package com.example.bottomnavigationbarjetpack

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.bottomnavigationbarjetpack.pages.HomePage
import com.example.bottomnavigationbarjetpack.pages.NotificationPage
import com.example.bottomnavigationbarjetpack.pages.SettingPage

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navItemList = listOf( // adding names and icons to bottom bar items
        NavItem("Home", Icons.Default.Home, 0),
        NavItem("Notification", Icons.Default.Notifications, 6),
        NavItem("Setting", Icons.Default.Settings, 0)
    )

    var selectedIndex by remember { //for transitions between the selection process
        mutableIntStateOf(0)
    }
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {//to add bottom bar items
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
                            BadgedBox(badge = {//bottom bar items for notification
                                if (navItem.badgCount > 0) {
                                    Badge {
                                        Text(text = navItem.badgCount.toString())
                                    }
                                }

                            }) { //bottom bar item icons
                                Icon(imageVector = navItem.icon, contentDescription = "Icon")
                            }

                        },
                        label = { Text(text = navItem.label) } //bottom bar item names
                    )
                }
            }
        }) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int) { // to switch between pages
    when (selectedIndex) {
        0 -> HomePage()
        1 -> NotificationPage()
        2 -> SettingPage()
    }
}