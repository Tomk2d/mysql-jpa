package mysql.ex.mysqljpa.service;

import mysql.ex.mysqljpa.domain.UserResume;
import mysql.ex.mysqljpa.repository.UserResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public UserResume findById(Long id) {
        Optional<UserResume> userResume = userResumeRepository.findById(id);
        return userResume.orElse(null);
    }
    public Long join(UserResume userResume){
        userResumeRepository.save(userResume);
        return userResume.getId();
    }
    public List<UserResume> getResumesByEmail(String email) {
        return userResumeRepository.findByEmail(email);
    }

    public UserResume getResumesById(Long id){
        return userResumeRepository.findById(id).orElse(null);
    }
    public void update(UserResume userResume) {
        userResumeRepository.save(userResume);
    }
}
