package inhye.hellomarket.service;

import inhye.hellomarket.domain.Member;
import inhye.hellomarket.domain.Role;
import inhye.hellomarket.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//서비스는 비즈니스를 처리하니까 그 롤에 맞는 네이밍을 해줄것
@Service
public class MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /*
    회원가입
     */
    @Transactional
    public Member join(Member member){

        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        member.setEnabled(true);

        Role role = new Role();
        role.setId(10L);
        member.getRoles().add(role);
        return memberRepository.save(member);
    }
}
