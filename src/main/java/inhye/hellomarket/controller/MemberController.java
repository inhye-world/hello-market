package inhye.hellomarket.controller;

import inhye.hellomarket.domain.Member;
import inhye.hellomarket.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
        private final MemberService memberService;

        @Autowired //spring container가 가지고있는 memberService를 controller와 연결해준다.
        public MemberController(MemberService memberService) {
                this.memberService = memberService;
        }

        @GetMapping("/members/new")
        public String createForm(){
                return "members/createMemberForm";
        }

        @PostMapping("/members/new")
        public String create(MemberForm form){
                Member member = new Member();
                member.setName(form.getName());
                member.setPassword(form.getPassword());

                memberService.join(member);

                return "redirect:/";
        }

        @GetMapping("/members")
        public String list(Model model){
                List<Member> members = memberService.findMembers();
                model.addAttribute("members", members);
                return "members/memberList";
        }
}
