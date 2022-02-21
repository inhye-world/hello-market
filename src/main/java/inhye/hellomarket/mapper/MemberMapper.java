package inhye.hellomarket.mapper;

import inhye.hellomarket.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MemberMapper {
    void singup(Member member);

    String chkPwd(String username);

    Member getSameUsername(String username);

    Member findByUsername(String username);
}