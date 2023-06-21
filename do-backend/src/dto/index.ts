import { IsNotEmpty, IsString } from 'class-validator';

export default class CreatememberDTO {
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
}
