package kr.hackersground.wsi.data.repository

import javax.inject.Inject
import kr.hackersground.wsi.data.remote.data.member.MemberRequest
import kr.hackersground.wsi.data.remote.mapper.toModel
import kr.hackersground.wsi.data.remote.service.MemberService
import kr.hackersground.wsi.domain.model.Member
import kr.hackersground.wsi.domain.repository.MemberRepository

class MemberRepositoryImpl @Inject constructor(
    private val memberService: MemberService
): MemberRepository {

    override suspend fun getAllMembers(): List<Member> =
        memberService.getAllMembers().data.toModel()

    override suspend fun createMember(
        name: String,
        latitude: Double,
        longitude: Double,
        pdfUrl: String,
    ) {
        memberService.createMember(
            MemberRequest(
                name = name,
                xAddress = latitude,
                yAddress = longitude,
                pdfUrl = pdfUrl,
            )
        )
    }
}
