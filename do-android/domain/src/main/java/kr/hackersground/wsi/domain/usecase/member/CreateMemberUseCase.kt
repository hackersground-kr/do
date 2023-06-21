package kr.hackersground.wsi.domain.usecase.member

import javax.inject.Inject
import kr.hackersground.wsi.domain.repository.MemberRepository

class CreateMemberUseCase @Inject constructor(
    private val memberRepository: MemberRepository,
) {

    suspend operator fun invoke(
        name: String,
        latitude: Double,
        longitude: Double,
        pdfUrl: String,
    ) = kotlin.runCatching {
        memberRepository.createMember(
            name = name,
            latitude = latitude,
            longitude = longitude,
            pdfUrl = pdfUrl,
        )
    }
}