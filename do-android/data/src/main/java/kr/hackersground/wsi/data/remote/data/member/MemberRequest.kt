package kr.hackersground.wsi.data.remote.data.member

import com.google.gson.annotations.SerializedName

data class MemberRequest(
    @SerializedName("name") val name: String,
    @SerializedName("xAddress") val xAddress: Double,
    @SerializedName("yAddress") val yAddress: Double,
    @SerializedName("pdfUrl") val pdfUrl: String,
)
