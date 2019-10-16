package kz.balalar.balalararticleservice.models;

import java.util.List;

public class ArticleInfo {

    private List<Comment> articleInfo;

    public List<Comment> getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(List<Comment> articleInfo) {
        this.articleInfo = articleInfo;
    }
}
