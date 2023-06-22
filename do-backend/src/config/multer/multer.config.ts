import { BadRequestException } from '@nestjs/common';
import { MulterOptions } from '@nestjs/platform-express/multer/interfaces/multer-options.interface';
import { existsSync, mkdirSync } from 'fs';
import { diskStorage } from 'multer';
import { extname } from 'path';

export const multerDiskOptions: MulterOptions = {
  fileFilter: (req, file, callback) => {
    if (file.mimetype.match(/\/(jpg|jpeg|png|pdf)$/)) {
      callback(null, true);
    } else {
      callback(new BadRequestException('이미지 파일은 jpg, jpeg, png, pdf 파일만 허용됩니다.'), false);
    }
  },

  storage: diskStorage({
    destination: (request, file, callback) => {
      const uploadPath = 'assets';
      if (!existsSync(uploadPath)) {
        // uploads 폴더가 존재하지 않을시, 생성합니다.
        mkdirSync(uploadPath);
      }
      callback(null, uploadPath);
    },
    filename: (request, file, callback) => {
      //파일 이름 설정
      callback(null, `${Date.now()}${extname(file.originalname)}`);
    },
  }),
};
