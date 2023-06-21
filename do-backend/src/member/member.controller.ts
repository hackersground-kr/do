import { Body, Controller, Get, Post } from '@nestjs/common';
import { MemberService } from './member.service';
import CreateMemberDTO from './dto/create.dto';

@Controller('members')
export class MemberController {
  constructor(private memberService: MemberService) {}

  @Get('/all')
  public async getAllMember() {
    const memberList = await this.memberService.getAllMember();
    return {
      status: 200,
      message: '모든 멤버 조회 성공',
      data: memberList,
    };
  }

  @Post()
  public async createMember(@Body() createMemberDTO: CreateMemberDTO) {
    await this.memberService.createMember(createMemberDTO);
    return {
      status: 200,
      message: '멤버 생성 성공',
    };
  }
}
