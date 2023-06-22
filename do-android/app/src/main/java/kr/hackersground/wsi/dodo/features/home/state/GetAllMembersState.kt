package kr.hackersground.wsi.dodo.features.home.state

import kr.hackersground.wsi.dodo.features.home.data.MemberData

data class GetAllMembersState (
    val isLoading: Boolean = false,
    val members: List<MemberData> = emptyList(),
    val error: Throwable? = null
)