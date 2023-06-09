package ru.avacodo.fktesttaskcompose.ui.screens.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.avacodo.fktesttaskcompose.R

@SuppressLint("AutoboxingStateValueProperty")
@Preview
@Composable
fun FKNavigationBar(selectedItem: MutableIntState = remember { mutableIntStateOf(0) }) {
    NavigationBar {
        FKNavigationBarItems.values().forEachIndexed { index, fkNavigationBarTitles ->
            NavigationBarItem(
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        painter = painterResource(fkNavigationBarTitles.iconResID),
                        contentDescription = "${fkNavigationBarTitles.title} item icon"
                    )
                },
                label = { Text(fkNavigationBarTitles.title) },
                selected = selectedItem.value == index,
                onClick = {
                    selectedItem.value = index
                }
            )
        }
    }
}

private enum class FKNavigationBarItems(val title: String, val iconResID: Int) {
    SCHEDULE("Занятия", R.drawable.ic_calendar),
    ORDERS("Заявки", R.drawable.ic_check_box),
    ADD("Добавить", R.drawable.ic_add),
    CHAT("Чат", R.drawable.ic_chat),
    MORE("Ещё", R.drawable.ic_more),
}