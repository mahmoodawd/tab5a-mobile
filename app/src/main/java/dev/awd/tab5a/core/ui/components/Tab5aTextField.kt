package dev.awd.tab5a.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun Tab5aTextField(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    isSecure: Boolean = false,
) {
    Column(modifier = modifier) {
        Text(
            title,
            color = MaterialTheme.colorScheme.onBackground
        )
        OutlinedTextField(
            value = TextFieldValue(value),
            onValueChange = {},
            readOnly = true,
            shape = RoundedCornerShape(16.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            leadingIcon = {
                leadingIcon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = leadingIcon.name
                    )
                }
            },
            trailingIcon = {
                trailingIcon
                trailingIcon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = trailingIcon.name
                    )
                }
            },
            singleLine = true,
        )
    }
}
