package mysql.ex.mysqljpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainPageController {

    @PostMapping("/page/jasosul")
    public String jasosul(){
        return "/page/jasosul";
    }
    @PostMapping("/page/news")
    public String news(){
        return "/page/news";
    }
    @PostMapping("/page/MyResume")
    public String myResume(){
        return "/page/MyResume";
    }
}
