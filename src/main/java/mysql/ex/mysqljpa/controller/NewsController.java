package mysql.ex.mysqljpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

@Controller
public class NewsController {

    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
        StringBuilder result = new StringBuilder();
        int lastPage = 5;

        for (int pageNum = 1; pageNum <= lastPage; pageNum++) {
            String url = "https://search.naver.com/search.naver?where=news&sm=tab_jum&query=" + keyword + "&start=" + ((pageNum - 1) * 10 + 1);
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select(".news_tit");

                result.append("\n\n").append(pageNum).append(" 페이지의 기사 ===================================================================\n\n");

                for (Element link : links) {
                    String title = link.text();
                    String articleUrl = link.attr("href");
                    result.append(title).append(" - ").append(articleUrl).append("\n\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        model.addAttribute("results", result.toString());
        return "/page/news"; // Thymeleaf 템플릿 뷰 이름
    }
}
