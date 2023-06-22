package kr.hackersground.wsi.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kr.hackersground.wsi.data.repository.FileRepositoryImpl
import kr.hackersground.wsi.data.repository.MemberRepositoryImpl
import kr.hackersground.wsi.domain.repository.FileRepository
import kr.hackersground.wsi.domain.repository.MemberRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun providesMemberRepository(
        memberRepositoryImpl: MemberRepositoryImpl
    ): MemberRepository

    @Singleton
    @Binds
    abstract fun providesFileRepository(
        fileRepositoryImpl: FileRepositoryImpl
    ): FileRepository
}
