package com.vickbt.shared.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Air
import androidx.compose.material.icons.rounded.Thermostat
import androidx.compose.material.icons.rounded.WaterDrop
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.vickbt.shared.domain.models.WeatherData
import com.vickbt.shared.domain.models.WeatherItem
import com.vickbt.shared.domain.utils.MeasurementOptions
import com.vickbt.shared.domain.utils.capitalizeEachWord
import com.vickbt.shared.domain.utils.setIntervalColor
import com.vickbt.shared.domain.utils.toImageFormat
import com.vickbt.shared.domain.utils.toReadableDateFormat
import com.vickbt.shared.domain.utils.toReadableDateTimeFormat
import com.vickbt.shared.domain.utils.toSpeedUnitOfMeasurement
import com.vickbt.shared.domain.utils.toTempUnitOfMeasurement
import com.vickbt.shared.ui.states.WeatherUiState
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun ItemWeatherData(
    modifier: Modifier = Modifier,
    weatherData: WeatherUiState<WeatherData, List<WeatherItem>>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space = 12.dp)
    ) {
        weatherData.locationCurrentWeather?.let {
            //region Location and Date Time
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 2.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                Text(
                    modifier = Modifier.testTag("location_text"),
                    text = "${weatherData.locationCurrentWeather.city.name}," +
                            " ${weatherData.locationCurrentWeather.city.country}",
                    fontWeight = FontWeight.Black,
                    fontSize = 24.sp,
                    maxLines = 2,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.testTag("date_text"),
                    text = Clock.System.now()
                        .toLocalDateTime(TimeZone.currentSystemDefault())
                        .toReadableDateFormat(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                weatherData.locationCurrentWeather.cachedLastAt?.let { cachedTime ->
                    Text(
                        modifier = Modifier.testTag("last_updated_text"),
                        text = "Last Updated: ${
                            Instant.fromEpochMilliseconds(cachedTime)
                                .toLocalDateTime(TimeZone.currentSystemDefault())
                                .toReadableDateTimeFormat()
                        }",
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = cachedTime.setIntervalColor()
                    )
                }
            }
            //endregion

            //region Current Condition
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier.size(150.dp),
                    model = weatherData.locationCurrentWeather.list.first().weather.first().icon.toImageFormat(),
                    contentDescription = "homeUiState.forecastWeather.current.condition.text",
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = weatherData.locationCurrentWeather.list.first().main.temp.toTempUnitOfMeasurement(
                        MeasurementOptions.METRIC
                    ),
                    fontSize = 80.sp,
                    fontWeight = FontWeight.ExtraBold,
                    maxLines = 1
                )

                Text(
                    text = weatherData.locationCurrentWeather.list.first().weather.first().description.capitalizeEachWord(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
            }
            //endregion

            HorizontalDivider(modifier = Modifier.padding(horizontal = 4.dp), thickness = 1.dp)

            //region Extra Conditions
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                item {
                    ExtraCondition(
                        icon = Icons.Rounded.WaterDrop,
                        title = "Humidity",
                        value = "${weatherData.locationCurrentWeather.list.first().main.humidity}%"
                    )
                }
                item {
                    ExtraCondition(
                        icon = Icons.Rounded.Thermostat,
                        title = "Feels Like",
                        value = weatherData.locationCurrentWeather.list.first().main.feelsLike.toTempUnitOfMeasurement()
                    )
                }
                item {
                    ExtraCondition(
                        icon = Icons.Rounded.Air,
                        title = "Wind",
                        value = weatherData.locationCurrentWeather.list.first().wind.speed
                            .toSpeedUnitOfMeasurement()
                    )
                }
            }
            //endregion

            HorizontalDivider(modifier = Modifier.padding(horizontal = 4.dp), thickness = 1.dp)
        }

        //region Weekly Forecast
        weatherData.locationWeatherForecast?.let {
            Text(text = "This Week", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

            Log.e("VicKbt", "Forecast: $it")

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = weatherData.locationWeatherForecast) { item ->
                    DayCondition(
                        modifier = Modifier.width(90.dp).wrapContentHeight(),
                        imageUrl = item.weather.first().icon.toImageFormat(),
                        dayOfWeek = item.dt,
                        minTemp = item.main.tempMin.toTempUnitOfMeasurement(),
                        maxTemp = item.main.tempMax.toTempUnitOfMeasurement()
                    )
                }
            }
        }
        //endregion
    }
}
