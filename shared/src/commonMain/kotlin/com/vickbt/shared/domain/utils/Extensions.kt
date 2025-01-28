package com.vickbt.shared.domain.utils

import androidx.compose.ui.graphics.Color
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.memory.MemoryCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import coil3.util.DebugLogger
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlin.time.Duration.Companion.hours

/**Format LocalDate time to human readable format ie. Monday, 01 January 1990*/
fun LocalDateTime.toReadableDateFormat(): String {
    return "${this.dayOfWeek}, ${this.dayOfMonth} ${this.month} $year".capitalizeEachWord()
}

fun LocalDateTime.toReadableDateTimeFormat(): String {
    return "${this.dayOfMonth} ${this.month}".capitalizeEachWord() + " at ${this.hour}:${this.minute}"
}

/**Capitalize each first letter of string ie. BIG brown is formatted to Big Brown*/
fun String.capitalizeEachWord(): String {
    return lowercase().split(" ").joinToString(" ") { firstCharacter ->
        firstCharacter.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase() else it.toString()
        }
    }
}

/**Appends degree celsius or degree fahrenheit depending on the [MeasurementOptions] passed*/
fun Double.toTempUnitOfMeasurement(unitOfMeasurement: MeasurementOptions = MeasurementOptions.METRIC): String {
    val value = this.toInt()

    return if (unitOfMeasurement == MeasurementOptions.METRIC) {
        "$value°C"
    } else {
        "$value°F"
    }
}

/**Appends kilometer per hour or miles per hour depending on [MeasurementOptions] passed*/
fun Double.toSpeedUnitOfMeasurement(unitOfMeasurement: MeasurementOptions = MeasurementOptions.METRIC): String {
    val value = this.toInt()

    return if (unitOfMeasurement == MeasurementOptions.METRIC) {
        "$value km/h"
    } else {
        "$value m/h"
    }
}

/**Appends [https:] to condition icon image url*/
fun String.toImageFormat(): String {
    return "https://openweathermap.org/img/wn/$this@2x.png"
}

fun Long.setIntervalColor(currentTime: Instant = Clock.System.now()): Color {
    val timeDifference = currentTime - Instant.fromEpochMilliseconds(this)

    return when {
        timeDifference <= 1.hours -> Color.Green
        timeDifference <= 2.hours -> Color.Yellow
        else -> Color.Red
    }
}

fun PlatformContext.getAsyncImageLoader() = ImageLoader.Builder(this)
    .crossfade(true)
    .memoryCachePolicy(CachePolicy.ENABLED)
    .memoryCache {
        MemoryCache.Builder().maxSizePercent(this, 0.3).strongReferencesEnabled(true).build()
    }
    .logger(DebugLogger())
    .build()
