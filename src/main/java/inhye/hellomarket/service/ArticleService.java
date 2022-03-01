package inhye.hellomarket.service;

import inhye.hellomarket.dto.Article;
import inhye.hellomarket.dto.Login;
import inhye.hellomarket.dto.Member;
import inhye.hellomarket.mapper.ArticleMapper;
import inhye.hellomarket.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    public List<Article> getArticleList() {
        return articleMapper.getArticleList();
    }

    public Article getArticle(int anum) {
        articleMapper.updateHit(anum);
        return articleMapper.getArticle(anum);
    }
}
