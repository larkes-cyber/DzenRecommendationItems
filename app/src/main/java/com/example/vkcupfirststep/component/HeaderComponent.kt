package com.example.vkcupfirststep.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupfirststep.ui.theme.*

@Composable
fun HeaderComponent(
    title:String,
    hideHeader: ()-> Unit
) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Box(Modifier.width(243.dp)) {
            Text(
                text = title,
                fontSize = (15.5).sp,
                color = TitleColor,
                fontFamily = abeezee,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                lineHeight = 20.sp
            )
        }
        Box(Modifier.width(87.dp)){
            Button(
                onClick = { hideHeader() },
                shape = RoundedCornerShape(40.dp),
                modifier = Modifier.height(43.dp).fillMaxWidth(),
                colors =  ButtonDefaults.buttonColors(backgroundColor = ButtonColor)
            ) {
                Text(
                    text = "Позже",
                    fontSize = 14.sp,
                    color = ItemTitleColor,
                    fontFamily = sfpro,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal,
                )
            }
        }

    }
}