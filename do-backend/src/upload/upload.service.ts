import { Injectable } from '@nestjs/common';
import { Response } from 'express';
import { createReadStream } from 'fs';
import { join } from 'path';

@Injectable()
export class UploadService {
  public async downloadFile(res: Response, filename: string): Promise<void> {
    const stream = createReadStream(join(__dirname, '../../../assets/' + filename));
    stream.pipe(res);
    return;
  }
}
