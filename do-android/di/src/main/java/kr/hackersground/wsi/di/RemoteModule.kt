package kr.hackersground.wsi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kr.hackersground.wsi.data.remote.service.MemberService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {

    @Singleton
    @Provides
    fun provideMemberRemote(retrofit: Retrofit): MemberService =
        retrofit.create(MemberService::class.java)
}
