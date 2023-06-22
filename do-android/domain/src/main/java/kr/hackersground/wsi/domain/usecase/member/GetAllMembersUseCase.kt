package kr.hackersground.wsi.domain.usecase.member

import javax.inject.Inject
import kr.hackersground.wsi.domain.model.Member
import kr.hackersground.wsi.domain.repository.MemberRepository

class GetAllMembersUseCase @Inject constructor(
    val memberRepository: MemberRepository,
) {

    suspend operator fun invoke(): Result<List<Member>> = kotlin.runCatching {
        memberRepository.getAllMembers()
    }
}