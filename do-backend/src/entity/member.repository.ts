import { Repository, EntityRepository } from 'typeorm';
import { Member } from './Member';

@EntityRepository(Member)
export class MemberRepository extends Repository<Member> {}
