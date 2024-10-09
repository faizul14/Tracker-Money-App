package com.faezolmp.tracker_money_app.presentation.component.componentDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.core.view.KeyEventDispatcher.Component

class TicketShape(
    private val cornerRadius: Dp = 16.dp,
    private val cutoutRadius: Dp = 16.dp,
    private val cutoutHeight: Float = 0.25f
) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val (width, height) = size
        val cornerRadius = this.cornerRadius.value
        val cornerRadiusSize = cornerRadius * 2
        val cutoutRadius = this.cutoutRadius.value
        val cutoutRadiusSize = cutoutRadius * 2

        val cutoutHeight = height * this.cutoutHeight

        val shape = Path()
        shape.moveTo(0f, cornerRadius)
        shape.arcTo(Rect(0f, 0f, cornerRadiusSize, cornerRadiusSize), 180f, 90f, false)
        shape.arcTo(Rect(width - cornerRadiusSize, 0f, width, cornerRadiusSize), 270f, 90f, false)
        shape.arcTo(
            Rect(width - cutoutRadius, cutoutHeight, width + cutoutRadius, cutoutHeight + cutoutRadiusSize),
            270f,
            -180f,
            false
        )
        shape.arcTo(Rect(width - cornerRadiusSize, height - cornerRadiusSize, width, height), 0f, 90f, false)
        shape.arcTo(Rect(0f, height - cornerRadiusSize, cornerRadiusSize, height), 90f, 90f, false)
        shape.arcTo(Rect(-cutoutRadius, cutoutHeight, cutoutRadius, cutoutHeight + cutoutRadiusSize), 90f, -180f, false)
        shape.lineTo(0f, cornerRadius)
        shape.close()
        return Outline.Generic(shape)
    }
}

@Composable
fun ComponentDetail() {
    val shape = TicketShape()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape)
//            .background(MaterialTheme.colorScheme.background)
            .background(Color.Black)
    )
}

//@Preview(showSystemUi = true)
@Preview
@Composable
fun ComponentDetailPreview() {
    ComponentDetail()
}