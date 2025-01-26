package com.vickbt.shared.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
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
import com.vickbt.shared.domain.utils.toReadableFormat
import com.vickbt.shared.domain.utils.toSpeedUnitOfMeasurement
import com.vickbt.shared.domain.utils.toTempUnitOfMeasurement
import com.vickbt.shared.ui.states.WeatherUiState
import kotlinx.datetime.Clock
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
                        .toReadableFormat(),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
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
                    model = "homeUiState.forecastWeather.current.condition.icon.toImageFormat()",
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

            Divider(modifier = Modifier.padding(horizontal = 4.dp), thickness = 1.dp)

            //region Extra Conditions
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                item {
                    ExtraCondition(
                        icon = "R.drawable.humidity_percentage",
                        title = "Humidity",
                        value = "${weatherData.locationCurrentWeather.list.first().main.humidity}%"
                    )
                }
                item {
                    ExtraCondition(
                        icon = "R.drawable.thermometer",
                        title = "Feels Like",
                        value = weatherData.locationCurrentWeather.list.first().main.feelsLike.toTempUnitOfMeasurement()
                    )
                }
                item {
                    ExtraCondition(
                        icon = "R.drawable.wind",
                        title = "Wind",
                        value = weatherData.locationCurrentWeather.list.first().wind.speed
                            .toSpeedUnitOfMeasurement()
                    )
                }
            }
            //endregion

            Divider(modifier = Modifier.padding(horizontal = 4.dp), thickness = 1.dp)
        }

        //region Weekly Forecast
        weatherData.locationWeatherForecast?.let {
            Text(text = "This Week", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items = weatherData.locationWeatherForecast) {
                    DayCondition(
                        modifier = Modifier.width(90.dp).wrapContentHeight(),
                        imageUrl = "it.day.condition.icon.toImageFormat()",
                        dayOfWeek = it.dt,
                        minTemp = it.main.tempMin.toTempUnitOfMeasurement(),
                        maxTemp = it.main.tempMax.toTempUnitOfMeasurement()
                    )
                }
            }
        }
        //endregion
    }

}
