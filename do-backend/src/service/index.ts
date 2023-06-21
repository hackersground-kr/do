import CreatememberDTO from '../dto/index';
import { Member } from '../entity/Member';
import { Service } from 'typedi';
// import { Repository } from 'typeorm';
import { MemberRepository } from '../entity/member.repository';
import { InjectRepository } from 'typeorm-typedi-extensions';

@Service()
export class MemberService {
  constructor(@InjectRepository() private memberRepository: MemberRepository) {}

  public async findAllMember(): Promise<Member[]> {
    return await this.memberRepository.find();
  }

  public async createmember(createMemberDTO: CreatememberDTO) {
    return await this.memberRepository.save({
      name: createMemberDTO.name,
      xAddress: createMemberDTO.xAddress,
      yAddress: createMemberDTO.yAddress,
      pdfUrl: createMemberDTO.pdfUrl,
    });
  }
}
