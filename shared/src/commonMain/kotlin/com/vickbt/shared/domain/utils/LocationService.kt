package com.vickbt.shared.domain.utils

import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.Flow

expect class LocationService {

    fun requestLocationUpdates(): Flow<LatLng?>
}
