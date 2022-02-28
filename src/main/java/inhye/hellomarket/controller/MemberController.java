package inhye.hellomarket.controller;

import inhye.hellomarket.dto.Login;
import inhye.hellomarket.dto.Member;
import inhye.hellomarket.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {
        @Autowired
        MemberService memberService;

        @GetMapping("/login")
        public String loginPage(@ModelAttribute Login login) throws Exception{
                return "members/loginForm";
        }

        //로그인 실패
        @GetMapping("/failLogin")
        public String loginFail() {

                return "members/failLogin";
        }

        @GetMapping("/new")
        public String createForm(Member member){
                return "members/createMemberForm";
        }

        @PostMapping("/new")
        public String create(Member member, Model model) throws Exception{
                Member chksameid = memberService.chkId(member.getUsername());

                if(chksameid != null) {
                        model.addAttribute("invalid_id", "이미 존재하는 아이디 입니다.");
                        return "members/createMemberForm";
                }

                //비밀번호 확인이 일치하지 않을 때
                if(!member.getPwd().isEmpty()){
                        if(!member.isPwdEqual()){
                                model.addAttribute("invalid_pwd_cf", "비밀번호가 일치하지 않습니다.");
                                return "members/createMemberForm";
                        }
                }

                memberService.signup(member);
                return "redirect:/hello";
        }
}
