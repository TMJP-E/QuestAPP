package com.algsafe.questapp

import androidx.annotation.IntRange
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.algsafe.questapp.ui.theme.BlackT100
import com.algsafe.questapp.ui.theme.BlackT90
import com.algsafe.questapp.ui.theme.Blush100
import com.algsafe.questapp.ui.theme.Gray60
import com.algsafe.questapp.ui.theme.Indigo100
import com.algsafe.questapp.ui.theme.Indigo80
import com.algsafe.questapp.ui.theme.Lavender100
import com.algsafe.questapp.ui.theme.Likert1
import com.algsafe.questapp.ui.theme.Likert2
import com.algsafe.questapp.ui.theme.Likert3
import com.algsafe.questapp.ui.theme.Likert4
import com.algsafe.questapp.ui.theme.Likert5
import com.algsafe.questapp.ui.theme.Phlox100
import com.algsafe.questapp.ui.theme.Red10
import com.algsafe.questapp.ui.theme.Red90
import com.algsafe.questapp.ui.theme.Rose00
import com.algsafe.questapp.ui.theme.Ruby10
import com.algsafe.questapp.ui.theme.White100CG
import com.algsafe.questapp.ui.theme.WhiteBG100

@Composable
fun IntroBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = WhiteBG100)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Rose00, Lavender100)
                ),
                alpha = 0.2f
            )
            .padding(all = 40.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun QuestAPPLogo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.app_logo_ref),
        contentDescription = stringResource(id = R.string.app_name),
        contentScale = ContentScale.Fit,
        modifier = modifier.size(size = 312.dp),
    )
}

@Composable
fun StartButton(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Red90,
            contentColor = Color.White,
            disabledContainerColor = Red10,
            disabledContentColor = Color.White,
        ), shape = RoundedCornerShape(size = 16.dp),
        modifier = Modifier.shadow(elevation = 4.dp)
    ) {
        Text(
            text = text, fontFamily = salsaFamily,
            fontSize = 48.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun SimpleTitle(text: String) {
    Text(
        text = text,
        fontFamily = salsaFamily,
        fontSize = 36.sp,
        textAlign = TextAlign.Center,
        color = BlackT90,
        style = LocalTextStyle.current.copy(
            shadow = Shadow(
                color = Color.Black,
                offset = Offset(0f, 8f),
                blurRadius = 8f
            )
        )
    )
}

@Composable
fun ContentText(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontFamily = poppinsFamily,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = BlackT100,
        modifier = modifier,
    )
}

@Composable
fun ProgressButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    Button(
        enabled = enabled,
        onClick = onClick,
        colors = ButtonColors(
            containerColor = Indigo100,
            contentColor = Color.Black,
            disabledContainerColor = Indigo80,
            disabledContentColor = Gray60,
        ),
        shape = RoundedCornerShape(size = 12.dp),
        modifier = modifier,
    ) {
        Text(
            text = text,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun QuestionBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = WhiteBG100)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Phlox100, Ruby10)
                ),
                alpha = 0.4f
            )
            .padding(horizontal = 20.dp, vertical = 60.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun SectionTitle(text: String) {
    Text(
        text = text,
        fontFamily = poppinsFamily,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .background(color = Blush100)
            .padding(horizontal = 48.dp, vertical = 4.dp)
    )
}

@Composable
fun QuestionDialog(text: String) {
    ContentText(
        text = text,
        modifier = Modifier
            .clip(RoundedCornerShape(36.dp))
            .background(color = White100CG)
            .padding(horizontal = 24.dp, vertical = 8.dp)
    )
}

@Composable
fun LikertSelector(
    @IntRange(from = 1, to = 5) level: Int,
    onClick: () -> Unit,
    selected: Boolean,
    modifier: Modifier = Modifier,
) {
    val colors = arrayOf(Likert1, Likert2, Likert3, Likert4, Likert5)
    val texts = arrayOf(
        stringResource(id = R.string.likert1),
        stringResource(id = R.string.likert2),
        stringResource(id = R.string.likert3),
        stringResource(id = R.string.likert4),
        stringResource(id = R.string.likert5)
    )
    val baseModifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 48.dp, vertical = 4.dp)


    Button(
        onClick = onClick,
        colors = ButtonColors(
            containerColor = colors[level - 1],
            contentColor = Color.Black,
            disabledContainerColor = White100CG,
            disabledContentColor = BlackT90,
        ),
        shape = RoundedCornerShape(size = 16.dp),
        modifier = if (selected) {
            baseModifier.border(
                width = 4.dp,
                color = Color.White,
                shape = RoundedCornerShape(size = 16.dp),
            )
        } else {
            baseModifier
        },
    ) {
        Text(
            text = texts[level - 1],
            fontFamily = robotoFamily,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
    }
}

