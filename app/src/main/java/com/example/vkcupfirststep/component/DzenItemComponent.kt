package com.example.vkcupfirststep.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkcupfirststep.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DzenItemComponent(title:String, changeCount:(Int) -> Unit) {

    val selectState = remember{
        mutableStateOf(false)
    }

    val transition = updateTransition(
        targetState = selectState.value,
        label = ""
    )
    val color by transition.animateColor(
        transitionSpec = { tween(300) },
        label = "",
        targetValueByState = { isSelect ->
            if(isSelect) SelectedItemColor else CardColor
        }
    )

    val rotatePlus by transition.animateFloat(
        transitionSpec = { tween(
            durationMillis = 500,
            easing = FastOutLinearInEasing
            ) },
        label = "",
        targetValueByState = {isSelect ->
                if(isSelect) 360f else 0f
        }
    )

    Card(
        backgroundColor = color,
        shape = RoundedCornerShape(12.dp),
        onClick = {
            changeCount(if(selectState.value) -1 else 1)
            selectState.value = !selectState.value
        },
        modifier = Modifier.height(40.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 8.dp)
                .padding(end = 12.dp)
        ) {
            Text(
                text = title,
                fontSize = 16.sp,
                color = ItemTitleColor,
                fontFamily = sfpro,
                fontWeight = FontWeight.SemiBold,
                fontStyle = FontStyle.Normal,
            )
            Spacer(Modifier.width(6.dp))
            if(!selectState.value){
                Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(20.dp),
                    color = DividerColor
                )
            }
            Spacer(Modifier.width(6.dp))

                Icon(
                    imageVector = if(rotatePlus > 320f) Icons.Default.Check else Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(if(selectState.value) 25.dp else 24.dp).rotate(rotatePlus)
                )

        }
    }
}