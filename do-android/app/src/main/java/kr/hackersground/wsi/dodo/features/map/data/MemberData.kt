package kr.hackersground.wsi.dodo.features.map.data

import kr.hackersground.wsi.dodo.util.getMajor
import ted.gun0912.clustering.clustering.TedClusterItem
import ted.gun0912.clustering.geometry.TedLatLng

data class MemberData(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val pdfUrl: String,
    val level: String = "Lv.${(1..10).random()}",
    val major: String = getMajor((1..10).random())
): TedClusterItem {

    override fun getTedLatLng(): TedLatLng {
        return TedLatLng(latitude, longitude)
    }
}
