package kz.balalar.balalararticleservice.models;

public class ArticleItem {

    private String name;
    private String desc;
    private String podcast_link;
    private String rating;


    public ArticleItem(String name, String desc, String podcast_link,String rating) {
        this.name = name;
        this.desc = desc;
        this.podcast_link = podcast_link;
        this.rating = rating;
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
}
