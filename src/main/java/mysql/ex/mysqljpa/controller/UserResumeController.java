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
        model.addAttribute("resumes", resumesByEmail);

        return "/page/MyResume";
    }

    @PostMapping("/resume/fix")
    public String fixResume(UserResumeForm form, HttpSession session, Model model) {
        // 세션에서 이메일 가져오기
        String email = (String) session.getAttribute("email");

        // 기존 자기소개서 객체를 ID를 이용해 조회
        UserResume userResume = userResumeService.getResumesById(form.getId());

        if (userResume != null) {
            userResume.setEmail(email); // 세션에서 가져온 이메일 사용
            userResume.setCompany(form.getCompany());
            userResume.setJob(form.getJob());
            userResume.setResume(form.getResume());
            userResumeService.update(userResume); // 업데이트 메서드 호출
        }

        // 업데이트 후 이메일로 자기소개서를 검색하고 모델에 추가
        List<UserResume> resumesByEmail = userResumeService.getResumesByEmail(email);
        model.addAttribute("resumes", resumesByEmail);

        return "/page/MyResume";
    }


}
