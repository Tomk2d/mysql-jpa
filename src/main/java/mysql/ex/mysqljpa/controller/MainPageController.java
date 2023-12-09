package mysql.ex.mysqljpa.controller;

import mysql.ex.mysqljpa.domain.UserResume;
import mysql.ex.mysqljpa.service.UserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "/page/jasosul";
    }
    @PostMapping("/page/news")
    public String news(){
        return "/page/news";
    }

    @PostMapping("/page/MyResume")
    public String myResume(Model model){
        List<UserResume> resumes = userResumeService.getAllResume();
        model.addAttribute("resumes",resumes);
        return "/page/MyResume";
    }
}
