package kz.balalar.balalararticleservice.models;

public class Trends {
    private String podcastId;
    private String articleId;
    private String trendId;
    private String categoryName;
    private String tags;

    public Trends(String podcastId, String articleId, String trendId, String categoryName, String tags) {
        this.podcastId = podcastId;
        this.articleId = articleId;
        this.trendId = trendId;
        this.categoryName = categoryName;
        this.tags = tags;
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

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
