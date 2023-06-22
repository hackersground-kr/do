package kr.hackersground.wsi.domain.model

import java.io.FileDescriptor

data class Talent(
    val id: Int,
    val name: String,
    val descriptor: String,
    val xAddress: Int,
    val yAddress: Int,
    val pdfUrl: String
)
