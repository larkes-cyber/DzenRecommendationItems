package com.example.vkcupfirststep.component

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DzenListComponent(items:List<String>, changeCount:(Int) -> Unit) {
    val cellConfiguration = if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        StaggeredGridCells.Adaptive(minSize = 90.dp)
    } else StaggeredGridCells.Fixed(11)

    LazyHorizontalStaggeredGrid(
        rows = cellConfiguration,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(items){index, item ->
            DzenItemComponent(title = item, changeCount = changeCount)
        }
    }
}