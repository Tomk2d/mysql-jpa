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
        return "/page/MyResumeGroup";
    }
    @PostMapping("/page/news")
    public String news(){
        return "/page/news";
    }

    @PostMapping("/page/MyResume")
    public String myResume(Model model, HttpSession session){
        String email = (String) session.getAttribute("email");
        List<UserResume> resume = userResumeService.getResumesByEmail(email);
        model.addAttribute("resume",resume);
        return "/page/MyResume";
    }
    @GetMapping("/page/MyResumeGroup")
    public String showResume(@RequestParam("email") String email, Model model) {
        List<UserResume> resume = userResumeService.getResumesByEmail(email);
        model.addAttribute("resume", resume);
        return "/page/MyResumeGroup";
    }
}