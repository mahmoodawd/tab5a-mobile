package dev.awd.tab5a.feature.auth

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.awd.tab5a.R
import dev.awd.tab5a.core.theme.Tab5aTheme

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit,
    onCreateAccountClick: () -> Unit,
    onLaterClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        TextButton(
            onClick = onLaterClick, modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(32.dp)
        ) {
            Text(
                text = stringResource(R.string.later),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyLarge,

                )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.weight(1f))
            Text(
                text = stringResource(R.string.greeting_message),
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 32.dp)
            )
            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(R.string.login),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }

            TextButton(onCreateAccountClick) {
                Text(
                    text = stringResource(R.string.create_new_account),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    Tab5aTheme {
        GreetingScreen(
            onLoginClick = {},
            onLaterClick = {},
            onCreateAccountClick = {}
        )
    }
}

@Preview(name = "Night", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun GreetingPreviewNight() {
    Tab5aTheme {
        GreetingScreen(
            onLoginClick = {},
            onLaterClick = {},
            onCreateAccountClick = {}
        )
    }
}

@Preview(showBackground = true, locale = "ar-rEG")
@Composable
private fun GreetingPreviewArabic() {
    Tab5aTheme {
        GreetingScreen(
            onLoginClick = {},
            onLaterClick = {},
            onCreateAccountClick = {}
        )
    }
}