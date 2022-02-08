package inhye.hellomarket.repository;

import inhye.hellomarket.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL select m from Member m where m.name = ?
    //인터페이스 이름만으로도 가능해진다!!!!
    @Override
    Optional<Member> findByName(String name);
}
