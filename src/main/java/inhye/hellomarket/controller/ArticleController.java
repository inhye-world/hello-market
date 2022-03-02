package inhye.hellomarket.controller;

import inhye.hellomarket.dto.Article;
import inhye.hellomarket.security.CustomUserDetails;
import inhye.hellomarket.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
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
        model.addAttribute("anum", anum);
        model.addAttribute("artist", article.getAname());
        return "article/detailPage";
    }

    /* 게시글 작성 */
    @GetMapping (value ="/writeView")
    public String writeView(@ModelAttribute Article article, Model model, @AuthenticationPrincipal CustomUserDetails principal){

        String userName = principal.getUsername();
        model.addAttribute("userName", userName);
        return "article/writePage";
    }

    @PostMapping(value ="/writeView")
    public String write(Article article, @AuthenticationPrincipal CustomUserDetails principal, Model model) throws Exception{

        String userName = principal.getUsername();
        article.setAname(userName);
        model.addAttribute("userName", userName);

        articleService.write(article);

        return "redirect:/articles/list";
    }
}
