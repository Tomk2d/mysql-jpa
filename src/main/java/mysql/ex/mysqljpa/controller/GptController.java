package mysql.ex.mysqljpa.controller;

import mysql.ex.mysqljpa.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GptController {
    @Autowired
    private CompanyService companyService;


    @GetMapping("/gptGet")
    public String showForm() {
        return "/page/gptResume";
    }
}
