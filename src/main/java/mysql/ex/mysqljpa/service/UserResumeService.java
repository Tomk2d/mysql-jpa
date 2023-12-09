package mysql.ex.mysqljpa.service;

import mysql.ex.mysqljpa.domain.UserResume;
import mysql.ex.mysqljpa.repository.UserResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserResumeService {

    private UserResumeRepository userResumeRepository;

    @Autowired
    public UserResumeService(UserResumeRepository userResumeRepository) {
        this.userResumeRepository = userResumeRepository;
    }


    public List<UserResume> getAllResume(){
        return userResumeRepository.findAll();
    }
}
