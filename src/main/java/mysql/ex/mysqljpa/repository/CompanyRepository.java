package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<article, Long> {

}
