package dev.awd.tab5a.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Tab5aIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    contentDescription: String?,
    icon: ImageVector,
    contentColor: Color,
    containerColor: Color,
) {
    IconButton(
        colors = IconButtonDefaults.iconButtonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        modifier = modifier
            .padding(16.dp)
            .background(containerColor, RoundedCornerShape(12.dp)),
        onClick = onClick
    ) {
        Icon(
            imageVector = icon, contentDescription = contentDescription,

            )
    }
}