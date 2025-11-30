package com.algsafe.questapp

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

private val prozaLibreName = GoogleFont("Proza Libre")
val prozaFamily = FontFamily(
    Font(googleFont = prozaLibreName, fontProvider = provider)
)

private val salsaName = GoogleFont("Salsa")
val salsaFamily = FontFamily(
    Font(googleFont = salsaName, fontProvider = provider)
)

private val poppinsName = GoogleFont("Poppins")
val poppinsFamily = FontFamily(
    Font(googleFont = poppinsName, fontProvider = provider)
)

private val robotoName = GoogleFont("Roboto")
val robotoFamily = FontFamily(
    Font(googleFont = robotoName, fontProvider = provider)
)