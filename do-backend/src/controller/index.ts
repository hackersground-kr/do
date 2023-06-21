import { MemberService } from '@base/service';
import { Inject, Service } from 'typedi';

@Service()
export class MemberController {
  @Inject()
  memberService: MemberService;
}
