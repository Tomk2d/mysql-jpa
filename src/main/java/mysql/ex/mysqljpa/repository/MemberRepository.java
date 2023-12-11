package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository {
    Optional<Member> save(Member member);
    Optional<Member> findById(Long id); // null 을 처리하는 과정에서 Optional 로 감싸서 처리하는 방법을 요즘 선호함.
    Optional<Member> findByEmail(String email); // id, name 을 불러옴.
    List<Member> findAll(); // 지금까지 저장된 회원 리스트를 모두 반환함.

}
