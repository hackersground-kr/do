package kr.hackersground.wsi.domain.model

data class Member(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val pdfUrl: String,
)