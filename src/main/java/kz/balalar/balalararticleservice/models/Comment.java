package kz.balalar.balalararticleservice.models;

public class Comment {

    private int commentId;
    private String name;

    public Comment() {

    }

    public Comment(int commentId, String name) {
        this.commentId = commentId;
        this.name = name;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
