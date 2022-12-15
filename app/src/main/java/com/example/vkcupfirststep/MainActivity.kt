package com.example.vkcupfirststep

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vkcupfirststep.component.ContinueButtonComponent
import com.example.vkcupfirststep.component.DzenItemComponent
import com.example.vkcupfirststep.component.DzenListComponent
import com.example.vkcupfirststep.component.HeaderComponent
import com.example.vkcupfirststep.ui.theme.BackgroundColor
import com.example.vkcupfirststep.ui.theme.VkCupFirstStepTheme


val data = listOf("Юмор","Рестораны","Политика","Автомобили","Рецепты","Отдых","Политика","Юмор","Рестораны","Политика","Юмор","Кино","Кино","Еда","Кино","Сериалы","Работа","Спорт","Новости","Прогулки","Еда","Прогулки","Кино","Еда","Кино")


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkCupFirstStepTheme {

                val selectedItemsCount = remember {
                    mutableStateOf(0)
                }
                val buttonState = remember {
                    mutableStateOf(false)
                }
                val headerState = remember {
                    mutableStateOf(true)
                }

                fun hideHeader(){
                    headerState.value = false
                }
                fun changeSelectedItemsCount(num:Int){
                    selectedItemsCount.value += num
                }



                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = BackgroundColor
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp)
                            .padding(top = 36.dp)) {

                        if(headerState.value){
                            Box(
                                Modifier
                                    .fillMaxHeight(0.10f)
                                    .fillMaxWidth()) {
                                HeaderComponent(title ="Отметьте то, что вам интересно, чтобы настроить Дзен", hideHeader = ::hideHeader)
                            }
                        }

                        Box(Modifier.fillMaxHeight(if(headerState.value) 0.82f else 0.75f)) {
                            DzenListComponent(items = data, changeCount = ::changeSelectedItemsCount)
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxHeight(if(headerState.value) 0.86f else 0.95f)
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            if(selectedItemsCount.value > 0) ContinueButtonComponent("Продолжить")
                        }
                    }

                }
            }
        }
    }
}



