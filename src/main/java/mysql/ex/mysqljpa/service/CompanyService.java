package mysql.ex.mysqljpa.service;

import mysql.ex.mysqljpa.domain.company;
import mysql.ex.mysqljpa.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;
    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
