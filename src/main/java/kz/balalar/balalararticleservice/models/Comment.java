package kz.balalar.balalararticleservice.models;

public class Comment {

    private String commentId;
    private String name;
    private String author;
    private String image;
    private String times;

    public Comment(String commentId, String name, String author, String image, String times) {
        this.commentId = commentId;
        this.name = name;
        this.author = author;
        this.image = image;
        this.times = times;
    }

    public Comment() {

    }
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
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
}
