package inhye.hellomarket.controller;

import inhye.hellomarket.domain.Member;
import inhye.hellomarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {
        @Autowired
        private final MemberService memberService;

        @Autowired //spring container가 가지고있는 memberService를 controller와 연결해준다.
        public MemberController(MemberService memberService) {
                this.memberService = memberService;
        }

        @GetMapping("/login")
        public String loginPage(){
                return "members/loginForm";
        }

        @GetMapping("/new")
        public String createForm(){
                return "members/createMemberForm";
        }

        @PostMapping("/new")
        public String create(Member member){
                memberService.join(member);
                return "redirect:/";
        }
}
