package inhye.hellomarket.controller;

import inhye.hellomarket.dto.Article;
import inhye.hellomarket.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/list")
    public String main(Model model){
        log.info("의뢰 리스트");
        model.addAttribute("articleList", articleService.getArticleList());
        return "article/articleList";
    }

    @RequestMapping("/details/{anum}")
    public String articleView(@PathVariable("anum") int anum, Model model){
        Article article = articleService.getArticle(anum);
        return "article/detailPage";
    }
}
