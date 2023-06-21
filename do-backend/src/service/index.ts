import { Member } from '@base/entity/Member';
import { Service } from 'typedi';
import { createQueryBuilder } from 'typeorm';

@Service()
export class MemberService {
  public async findAllMember() {
    return await createQueryBuilder('member').getMany();
  }

  public async createmember(createMemberDTO: CreatememberDTO) {
    return await createQueryBuilder('member')
      .insert()
      .values({
        name: createMemberDTO.name,
        xAddress: createMemberDTO.xAddress,
        yAddress: createMemberDTO.yAddress,
        pdfUrl: createMemberDTO.pdfUrl,
      })
      .execute();
  }
}
