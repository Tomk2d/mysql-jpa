package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.UserResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserResumeRepository extends JpaRepository<UserResume, Long> {
}
