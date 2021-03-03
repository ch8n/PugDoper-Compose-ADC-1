package dev.ch8n.pubdopter.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.ch8n.pubdopter.R


val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semibold, FontWeight.SemiBold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = sp24,
        color = TextColor
    ),
    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Bold,
        fontSize = sp16,
        color = TextColor
    ),
    caption = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = sp10,
        color = TextColor
    ),
    body1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = sp14,
        color = TextColor
    ),
    body2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Normal,
        fontSize = sp12,
        color = TextColor
    ),
    button = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.Medium,
        fontSize = sp16,
        color = TextColor
    ),
)