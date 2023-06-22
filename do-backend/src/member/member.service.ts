import { Injectable } from '@nestjs/common';
import CreateMemberDTO from './dto/create.dto';
import { Member } from './entity/member.entity';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';

@Injectable()
export class MemberService {
  constructor(@InjectRepository(Member) private memberRepository: Repository<Member>) {}

  public async getAllMember(): Promise<Member[]> {
    return await this.memberRepository.find();
  }

  public async createMember(createMemberDTO: CreateMemberDTO): Promise<void> {
    await this.memberRepository.save({
      name: createMemberDTO.name,
      xAddress: createMemberDTO.xAddress,
      yAddress: createMemberDTO.yAddress,
      pdfUrl: createMemberDTO.pdfUrl,
      summary: '',
    });
  }
}
