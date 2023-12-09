package mysql.ex.mysqljpa.controller;

import jakarta.servlet.http.HttpSession;
import mysql.ex.mysqljpa.domain.UserResume;
import mysql.ex.mysqljpa.service.UserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserResumeController {

    private UserResumeService userResumeService;
    @Autowired
    public UserResumeController(UserResumeService userResumeService) {
        this.userResumeService = userResumeService;
    }


    @PostMapping("/page/MyResumeGroup")
    public String createNewResume() {
        return "/page/MyResumeGroup"; // 새 자기소개서 작성 페이지의 뷰 이름
    }


    @PostMapping("/resume/save")
    public String createResume(UserResumeForm form, HttpSession session, Model model){
        UserResume userResume = new UserResume();
        userResume.setId(form.getId());
        userResume.setEmail(form.getEmail());
        userResume.setCompany(form.getCompany());
        userResume.setJob(form.getJob());
        userResume.setResume(form.getResume());
        userResumeService.join(userResume);

        String email = (String) session.getAttribute("email");

        // 이메일로 자기소개서를 검색하고 모델에 추가
        List<UserResume> resumesByEmail = userResumeService.getResumesByEmail(email);
        model.addAttribute("resume", resumesByEmail);

        return "/page/MyResume";
    }


}
