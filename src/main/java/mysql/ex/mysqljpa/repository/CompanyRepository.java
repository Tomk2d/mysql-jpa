package mysql.ex.mysqljpa.repository;

import mysql.ex.mysqljpa.domain.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<company, Long> {

}
