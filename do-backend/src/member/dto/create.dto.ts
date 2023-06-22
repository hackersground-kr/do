import { IsNumber, IsString } from 'class-validator';

export default class CreateMemberDTO {
  @IsString()
  name!: string;

  @IsNumber()
  xAddress!: number;

  @IsNumber()
  yAddress!: number;

  @IsString()
  pdfUrl!: string;
}
