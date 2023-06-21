package kr.hackersground.wsi.data.remote.data

data class Response<T>(
    val message: String,
    val status: Int,
    val data: T,
)
