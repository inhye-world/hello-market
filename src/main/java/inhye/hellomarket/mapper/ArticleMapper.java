package inhye.hellomarket.mapper;

import inhye.hellomarket.dto.Article;
import inhye.hellomarket.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {
    List<Article> getArticleList();

    void updateHit(int anum);

    Article getArticle(int anum);
}