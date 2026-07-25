package dev.awd.tab5a.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.twotone.Call
import androidx.compose.material.icons.twotone.Mail
import androidx.compose.material.icons.twotone.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun RegisterScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.padding(vertical = 16.dp).clickable(onClick = {})
            )

        Text(
            text = stringResource(R.string.register),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.register_instruction),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp),
        )
        Tab5aTextField(
            title = "Full Name",
            value = sampleUser.name,
            leadingIcon = Icons.TwoTone.Mail,
        )
        Tab5aTextField(
            title = "Email",
            value = sampleUser.email,
            leadingIcon = Icons.TwoTone.Mail,
        )
        Tab5aTextField(
            title = "Mobile Number",
            value = sampleUser.mobile,
            leadingIcon = Icons.TwoTone.Call,
        )
        Tab5aTextField(
            title = "Password",
            value = "***",
            trailingIcon = Icons.TwoTone.RemoveRedEye,
        )
        Tab5aButton(
            onClick = {},
            label = stringResource(R.string.register),
            modifier = Modifier,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.alraedy_have_account),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .padding(bottom = 8.dp),
            )
            TextButton(onClick = {}) {
                Text(
                    text = stringResource(R.string.login),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(bottom = 8.dp),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterPreview() {
    Tab5aTheme {
        RegisterScreen()
    }

}