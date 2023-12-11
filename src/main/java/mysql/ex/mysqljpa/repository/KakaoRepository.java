package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.Kakaouser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KakaoRepository extends JpaRepository<Kakaouser,String> {

}
