package kr.hackersground.wsi.dodo.util

internal fun getMajor(num: Int): String = when(num) {
    1 -> "Android"
    2 -> "Front-end"
    3 -> "Back-end"
    4 -> "iOS"
    5 -> "Mobile"
    6 -> "Embedded"
    7 -> "ML"
    8 -> "Game"
    9 -> "BigData"
    10 -> "Security"
    else -> "ETC"
}