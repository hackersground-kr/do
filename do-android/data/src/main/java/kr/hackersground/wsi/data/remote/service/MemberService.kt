package kr.hackersground.wsi.data.remote.service

import kr.hackersground.wsi.data.remote.data.Response
import kr.hackersground.wsi.data.remote.data.member.MemberRequest
import kr.hackersground.wsi.data.remote.data.member.MemberResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MemberService {

    @GET("members/all")
    suspend fun getAllMembers(): Response<List<MemberResponse>>

    @POST("members")
    suspend fun createMember(
        @Body memberRequest: MemberRequest
    ): Response<Unit>
}
