package dev.awd.tab5a.ui.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.twotone.Mail
import androidx.compose.material.icons.twotone.RemoveRedEye
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.awd.tab5a.R
import dev.awd.tab5a.ui.common.components.Tab5aButton
import dev.awd.tab5a.ui.common.components.Tab5aTextField
import dev.awd.tab5a.ui.common.sampleUser
import dev.awd.tab5a.ui.theme.Tab5aTheme

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.login_instruction),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Text(
            text = sampleUser.name,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp, bottom = 8.dp)
        )
        Tab5aTextField(
            title = "Email",
            value = sampleUser.email,
            leadingIcon = Icons.TwoTone.Mail,
        )
        Tab5aTextField(
            title = "Password",
            value = "***",
            trailingIcon = Icons.TwoTone.RemoveRedEye,
        )
        Text(
            text = stringResource(R.string.forgot_password),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .align(Alignment.End)
                .padding(vertical = 4.dp),
        )
        Tab5aButton(
            onClick = {},
            label = stringResource(R.string.login),
            modifier = Modifier,
        )
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.or),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            HorizontalDivider(modifier = Modifier.weight(1f))
        }
        OutlinedIconTextButton(
            onClick = {},
            label = stringResource(R.string.google),
            icon = Icons.Filled.Facebook,
            modifier = Modifier,
        )
        OutlinedIconTextButton(
            onClick = {},
            label = stringResource(R.string.facebook),
            icon = Icons.Filled.Facebook,
            modifier = Modifier,
        )

        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.dont_have_account),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(bottom = 8.dp),
            )
            TextButton(onClick = {}) {
                Text(
                    text = stringResource(R.string.register),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                )
            }
        }
    }
}

@Composable
fun OutlinedIconTextButton(
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit,
    label: String,
    icon: ImageVector,
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(
            contentColor = contentColor,
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp,
                bottom = 16.dp
            )
    )
    {
        Icon(
            imageVector = icon, contentDescription = icon.name,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun LoginPreview() {
    Tab5aTheme {
        LoginScreen()
    }
}