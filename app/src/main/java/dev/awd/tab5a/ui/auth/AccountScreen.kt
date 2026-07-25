package dev.awd.tab5a.ui.auth

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AddBox
import androidx.compose.material.icons.twotone.Call
import androidx.compose.material.icons.twotone.Language
import androidx.compose.material.icons.twotone.Mail
import androidx.compose.material.icons.twotone.RemoveRedEye
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.error
import coil3.request.placeholder
import dev.awd.tab5a.R
import dev.awd.tab5a.ui.common.components.Tab5aButton
import dev.awd.tab5a.ui.common.components.Tab5aTextField
import dev.awd.tab5a.ui.common.sampleUser
import dev.awd.tab5a.ui.theme.Tab5aTheme

@Composable
fun AccountScreen(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.account),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 8.dp)
        )
        Box {
            AsyncImage(
                model = ImageRequest.Builder(context)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .data(sampleUser.imageUrl)
                    .error(R.drawable.ic_launcher_foreground)
                    .build(),
                contentDescription = sampleUser.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(16.dp)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.TwoTone.AddBox, contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomEnd)
                    .background(
                        MaterialTheme.colorScheme.background,
                        RoundedCornerShape(12.dp)
                    )
                    .padding(8.dp)
            )
        }
        Text(
            sampleUser.name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
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
        Tab5aTextField(
            title = "Language",
            value = "English",
            leadingIcon = Icons.TwoTone.Language,
        )

        Tab5aButton(
            label = stringResource(R.string.logout),
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            onClick = { }
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_TYPE_NORMAL, showSystemUi = true)
@Composable
private fun AccountPreview() {
    Tab5aTheme {
        AccountScreen()
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
private fun AccountPreviewNight() {
    Tab5aTheme {
        AccountScreen()
    }
}