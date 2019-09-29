package kz.balalar.balalararticleservice.models;

public class Trends {
    private String podcastId;
    private String articleId;
    private String trendId;

    public Trends(String podcastId, String articleId, String trendId) {
        this.podcastId = podcastId;
        this.articleId = articleId;
        this.trendId = this.trendId;
    }

    public Trends() {

    }

    public String getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(String podcastId) {
        this.podcastId = podcastId;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getTrendId() {
        return trendId;
    }

    public void setTrendId(String trendId) {
        this.trendId = trendId;
    }
}
