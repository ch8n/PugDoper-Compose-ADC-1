package dev.ch8n.pubdopter.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.ui.theme.*
import dev.ch8n.pubdopter.ui.theme.dp4


@Composable
fun DetailInfoCell(label: String, value: String) {
    Column(
        modifier = Modifier.padding(end = dp16)
    ) {
        Text(
            text = label.capitalize(),
            style = MaterialTheme.typography.caption
        )

        Spacer(modifier = Modifier.height(dp2))

        Text(
            text = value.capitalize(),
            style = MaterialTheme.typography.body2
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