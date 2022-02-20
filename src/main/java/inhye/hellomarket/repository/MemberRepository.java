package inhye.hellomarket.repository;

import inhye.hellomarket.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);

    Optional<Member> findById(Long id); //id가 없는 경우에 null이 반환되는데 이 경우릴 처리하기 위함

    Optional<Member> findByUsername(String username);

    List<Member> findAll();
}
