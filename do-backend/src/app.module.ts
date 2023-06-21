import { Module } from '@nestjs/common';
import { MemberModule } from './member/member.module';
import { DatabaseModule } from './config/database/database.module';
import { ConfigModule } from '@nestjs/config';
import { UploadModule } from './upload/upload.module';

@Module({
  imports: [
    ConfigModule.forRoot({
      isGlobal: true,
    }),
    DatabaseModule,
    MemberModule,
    UploadModule,
  ],
  controllers: [],
  providers: [],
})
export class AppModule {}
