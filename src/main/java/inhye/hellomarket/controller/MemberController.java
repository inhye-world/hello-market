package inhye.hellomarket.controller;

import inhye.hellomarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
        private final MemberService memberService;

        @Autowired //spring container가 가지고있는 memberService를 controller와 연결해준다.
        public MemberController(MemberService memberService) {
                this.memberService = memberService;
        }

}
