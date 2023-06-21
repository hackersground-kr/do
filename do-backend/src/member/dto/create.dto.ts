import { IsNotEmpty, IsString } from 'class-validator';

export default class CreateMemberDTO {
  @IsString()
  @IsNotEmpty()
  name!: string;

  @IsString()
  @IsNotEmpty()
  xAddress!: number;

  @IsString()
  @IsNotEmpty()
  yAddress!: number;

  @IsString()
  @IsNotEmpty()
  pdfUrl!: string;

  @IsString()
  @IsNotEmpty()
  summary!: string;
}
