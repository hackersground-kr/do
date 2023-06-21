import { Bind, Controller, Post, UploadedFile, UseInterceptors } from '@nestjs/common';
import { FileInterceptor } from '@nestjs/platform-express';
import { multerDiskOptions } from 'src/config/multer/multer.config';

@Controller('uploads')
export class UploadController {
  @Post()
  @UseInterceptors(FileInterceptor('file', multerDiskOptions))
  @Bind(UploadedFile())
  public uploadFile(file: any) {
    return {
      status: 200,
      message: '파일 등록 성공',
      data: file.filename,
    };
  }
}
