package mysql.ex.mysqljpa.service;

import jakarta.persistence.EntityManager;
import mysql.ex.mysqljpa.repository.JpaMemberRepository;
import mysql.ex.mysqljpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {

    private final DataSource dataSource;
    private EntityManager em;

    @Autowired
    public Config(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }


    @Bean
    public MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
    }


}
