package kr.hackersground.wsi.domain.repository

import kr.hackersground.wsi.domain.model.Member

interface MemberRepository {

    suspend fun getAllMembers(): List<Member>

    suspend fun createMember(
        name: String,
        latitude: Double,
        longitude: Double,
        pdfUrl: String,
    )
}