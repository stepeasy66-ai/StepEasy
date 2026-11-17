package uk.ac.tees.mad.stepeasy.ui.splash.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import uk.ac.tees.mad.stepeasy.ui.theme.Dimens

@Composable
fun PremiumLinearLoader(
    modifier: Modifier = Modifier
) {

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val animatedOffset by infiniteTransition.animateFloat(
        initialValue = -200f,
        targetValue = 800f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1200,
                easing = LinearEasing
            )
        ),
        label = ""
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.paddingLarge)
            .height(6.dp)
            .clip(RoundedCornerShape(50))
            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(120.dp)
                .offset(x = animatedOffset.dp)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)
                        ),
                        start = Offset.Zero,
                        end = Offset.Infinite
                    ),
                    shape = RoundedCornerShape(50)
                )
        )
    }
}