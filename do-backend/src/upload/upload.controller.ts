import { Bind, Controller, Get, Param, Post, Response, UploadedFile, UseInterceptors } from '@nestjs/common';
import { FileInterceptor } from '@nestjs/platform-express';
import { multerDiskOptions } from '../config/multer/multer.config';
import { UploadService } from './upload.service';
import { Response as ResponseE } from 'express';
import { ConfigService } from '@nestjs/config';

@Controller('/files')
export class UploadController {
  constructor(private uploadService: UploadService, private configService: ConfigService) {}

  @Post()
  @UseInterceptors(FileInterceptor('file', multerDiskOptions))
  @Bind(UploadedFile())
  public uploadFile(file: any) {
    return {
      status: 200,
      message: '파일 등록 성공',
      data: `http://localhost:${this.configService.get<string>('PORT')}/files/${file.filename}`,
    };
  }

  @Get('/:filename')
  public downloadFile(@Response() res: ResponseE, @Param('filename') filename: string): Promise<void> {
    return this.uploadService.downloadFile(res, filename);
  }
}
