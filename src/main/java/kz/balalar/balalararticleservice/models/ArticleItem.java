package kz.balalar.balalararticleservice.models;

public class ArticleItem {

    private String name;
    private String desc;
    private String podcast_link;
    private String rating;
    private String categoryTrends;
    private String tagsTrends;
    private String image;
    private String author;
    private String timeline;

    public ArticleItem(String name, String desc, String podcast_link, String rating, String categoryTrends, String tagsTrends, String image, String author, String timeline) {
        this.name = name;
        this.desc = desc;
        this.podcast_link = podcast_link;
        this.rating = rating;
        this.categoryTrends = categoryTrends;
        this.tagsTrends = tagsTrends;
        this.image = image;
        this.author = author;
        this.timeline = timeline;
    }

    public ArticleItem() {

    }
    public String getRating() {
        return rating;
    }

    public String getPodcast_link() {
        return podcast_link;
    }

    public void setPodcast_link(String podcast_link) {
        this.podcast_link = podcast_link;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategoryTrends() {
        return categoryTrends;
    }

    public void setCategoryTrends(String categoryTrends) {
        this.categoryTrends = categoryTrends;
    }

    public String getTagsTrends() {
        return tagsTrends;
    }

    public void setTagsTrends(String tagsTrends) {
        this.tagsTrends = tagsTrends;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTimeline() {
        return timeline;
    }

    public void setTimeline(String timeline) {
        this.timeline = timeline;
    }
}
