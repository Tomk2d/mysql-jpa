package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.UserResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserResumeRepository extends JpaRepository<UserResume, Long> {
    List<UserResume> findByEmail(String email);
}
