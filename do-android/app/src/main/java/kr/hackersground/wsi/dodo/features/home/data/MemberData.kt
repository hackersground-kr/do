package kr.hackersground.wsi.dodo.features.home.data

import kr.hackersground.wsi.dodo.util.getMajor

data class MemberData(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val pdfUrl: String,
    val level: String = "Lv.${(1..10).random()}",
    val major: String = getMajor((1..10).random()),
)
