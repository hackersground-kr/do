package kr.hackersground.wsi.dodo.features.map.state

import kr.hackersground.wsi.dodo.features.map.data.MemberData

data class GetAllMembersState(
    val isLoading: Boolean = false,
    val members: List<MemberData> = emptyList(),
    val error: Throwable? = null,
)
