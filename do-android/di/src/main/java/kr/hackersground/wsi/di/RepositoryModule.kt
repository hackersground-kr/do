package kr.hackersground.wsi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kr.hackersground.wsi.data.repository.MemberRepositoryImpl
import kr.hackersground.wsi.domain.repository.MemberRepository

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMemberRepository(memberRepositoryImpl: MemberRepositoryImpl): MemberRepository = memberRepositoryImpl
}
