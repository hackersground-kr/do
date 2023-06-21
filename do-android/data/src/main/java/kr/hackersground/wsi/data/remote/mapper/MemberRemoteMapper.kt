package kr.hackersground.wsi.data.remote.mapper

import kr.hackersground.wsi.data.remote.data.member.MemberResponse
import kr.hackersground.wsi.domain.model.Member

internal fun List<MemberResponse>.toModel() = this.map {
    it.toModel()
}

internal fun MemberResponse.toModel() = Member(
    name = this.name,
    latitude = this.xAddress,
    longitude = this.yAddress,
    pdfUrl = this.pdfUrl,
)
