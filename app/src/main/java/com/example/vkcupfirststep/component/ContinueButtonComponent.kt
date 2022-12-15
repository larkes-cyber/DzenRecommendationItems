package com.example.vkcupfirststep.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupfirststep.ui.theme.ButtonColor
import com.example.vkcupfirststep.ui.theme.ItemTitleColor
import com.example.vkcupfirststep.ui.theme.sfpro
import com.example.vkcupfirststep.ui.theme.yandexSans

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContinueButtonComponent(title:String) {
    Card(
        onClick = {
        },
        shape = RoundedCornerShape(74.dp),
        backgroundColor =  Color.White
    ) {
        Row(modifier = Modifier.padding(horizontal = 51.dp, vertical = 22.dp)) {
            Text(
                text = title,
                fontSize = 18.sp,
                color = Color.Black,
                fontFamily = yandexSans,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Normal,
            )
        }
    }
}