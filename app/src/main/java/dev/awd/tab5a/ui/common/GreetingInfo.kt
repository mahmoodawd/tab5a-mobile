package dev.awd.tab5a.ui.common
import android.content.Context
import android.icu.util.Calendar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brightness4
import androidx.compose.material.icons.filled.Brightness5
import androidx.compose.material.icons.filled.Brightness6
import androidx.compose.ui.graphics.vector.ImageVector
import dev.awd.tab5a.R as Resources

data class GreetingInfo(
    val greetingText: String,
    val icon: ImageVector,
)

fun getGreetingInfo(context: Context): GreetingInfo {
    val calendar = Calendar.getInstance()
    val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

    return when (hourOfDay) {
        in 5..11 -> GreetingInfo(
            context.getString(Resources.string.good_morning),
            Icons.Default.Brightness5
        )

        in 12..16 -> GreetingInfo(
            context.getString(Resources.string.good_afternoon),
            Icons.Default.Brightness6
        )

        else -> GreetingInfo(
            context.getString(Resources.string.good_evening),
            Icons.Default.Brightness4
        )
    }
}