package com.vickbt.shared.domain.utils

/**Application constants*/
object Constants {

    const val BASE_URL = "api.openweathermap.org"
    const val URL_PATH = "data/2.5/"

    // Multiplatform-settings keys
    const val THEME_KEY = "theme_key"
    const val MEASUREMENT_KEY = "measurement_key"
}

enum class ThemeOptions {
    LIGHT_THEME, DARK_THEME
}

enum class MeasurementOptions {
    METRIC, IMPERIAL
}
