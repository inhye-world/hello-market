package inhye.hellomarket.service;

import inhye.hellomarket.dto.Login;
import inhye.hellomarket.dto.Member;
import inhye.hellomarket.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

//서비스는 비즈니스를 처리하니까 그 롤에 맞는 네이밍을 해줄것
@Slf4j
@Service
public class MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Map<String, String> validHandler(Member form, Errors errors){
        Map<String, String> validRes = new HashMap<>();

        for(FieldError error : errors.getFieldErrors()){
            String validKey = String.format("invalid_%s", error.getField());
            validRes.put(validKey, error.getDefaultMessage());
        }

        return validRes;
    }

    public void signup(Member form) throws Exception{
        //비밀번호 암호화
        String encoded = passwordEncoder.encode(form.getPwd());
        form.setPwd(encoded);

        memberMapper.singup(form);
    }

    public Boolean checkUser(Login login) {
        String rawPwd = login.getPwd();
        String userPwd = memberMapper.chkPwd(login.getUsername());

        return passwordEncoder.matches(rawPwd, userPwd);
    }

    public Member chkId(String username) {
        return memberMapper.getSameUsername(username);
    }
}
