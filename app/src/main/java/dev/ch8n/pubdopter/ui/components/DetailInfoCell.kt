package dev.ch8n.pubdopter.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.ui.theme.PubDopterTheme
import dev.ch8n.pubdopter.ui.theme.dp4
import dev.ch8n.pubdopter.ui.theme.sp10
import dev.ch8n.pubdopter.ui.theme.sp14


@Composable
fun DetailInfoCell(label: String, value: String) {
    Column {
        Text(
            text = label.capitalize(),
            fontSize = sp14,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(dp4))

        Text(
            text = value.capitalize(),
            fontSize = sp10
        )
    }
}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDetailInfoCell() {
    PubDopterTheme {
        DetailInfoCell(
            label = "test",
            value = "value"
        )
    }
}