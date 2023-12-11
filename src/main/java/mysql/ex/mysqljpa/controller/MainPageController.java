package mysql.ex.mysqljpa.controller;

import jakarta.servlet.http.HttpSession;
import mysql.ex.mysqljpa.domain.UserResume;
import mysql.ex.mysqljpa.service.UserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainPageController {

    @Autowired
    private final UserResumeService userResumeService;

    public MainPageController(UserResumeService userResumeService) {
        this.userResumeService = userResumeService;
    }

    @PostMapping("/page/jasosul")
    public String jasosul(){
        return "/page/gpt";
    }
    @PostMapping("/page/news")
    public String news(){
        return "/page/news";
    }

    @PostMapping("/page/MyResume")
    public String myResume(Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        List<UserResume> resumes = userResumeService.getResumesByEmail(email);
        model.addAttribute("resumes",resumes);
        return "/page/MyResume";
    }
    @GetMapping("/page/MyResumeGroup")
    public String showResume(@RequestParam("id") Long id, Model model) {
        UserResume resume = userResumeService.getResumesById(id); // 단일 객체 조회
        model.addAttribute("resume", resume);
        return "/page/MyResumeGroup";
    }
    @PostMapping("/page/newResume")
    public String createNewResume() {
        return "/page/NewResume"; // 새 자기소개서 작성 페이지의 뷰 이름
    }

    @PostMapping("/page/goMain")
    public String goMain(){
        return "/page/mainpage";
    }
}
