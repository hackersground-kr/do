import CreatememberDTO from '../dto/index';
import { MemberService } from '../service/index';
import { Body, Get, JsonController, Post } from 'routing-controllers';
import { Service } from 'typedi';

@Service()
@JsonController('/members')
export class MemberController {
  constructor(private memberService: MemberService) {}

  @Get('/all')
  public async findAll() {
    return {
      status: 200,
      message: '모든 멤버 조회 성공',
      data: await this.memberService.findAllMember(),
    };
  }

  @Post()
  public async createMember(@Body() createMemerDTO: CreatememberDTO) {
    await this.memberService.createmember(createMemerDTO);
    return {
      status: 200,
      message: '멤버 생성 성공',
    };
  }
}
