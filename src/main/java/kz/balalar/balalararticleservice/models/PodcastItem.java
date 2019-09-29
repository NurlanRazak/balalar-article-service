package kz.balalar.balalararticleservice.models;

public class PodcastItem {

    private String name;
    private String desc;
    private String link;
    private int rating;

    public PodcastItem() {

    }

    public PodcastItem(String name, String desc, String link, int rating) {
        this.name = name;
        this.desc = desc;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
