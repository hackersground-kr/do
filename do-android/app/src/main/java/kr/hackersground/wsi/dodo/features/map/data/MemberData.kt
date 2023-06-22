package kr.hackersground.wsi.dodo.features.map.data

import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng

data class MemberData(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val pdfUrl: String,
): TedClusterItem {

    override fun getTedLatLng(): TedLatLng {
        return TedLatLng(latitude, longitude)
    }
}
