package inhye.hellomarket;

import inhye.hellomarket.domain.Member;
import inhye.hellomarket.repository.MemberRepository;
import inhye.hellomarket.repository.MemoryMemberRepository;
import inhye.hellomarket.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean //MemoryMemberRepository를 변경하면 이것만 수정하면된다!
    //컴포넌트 스캔은 변경해야 하는 것들이 많다.
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
