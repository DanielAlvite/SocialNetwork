package org.campusdual;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private int id; // Identificador único del post
    private Date date;
    private List<Comment> comments;
    private User author; // Autor del post
    private String content;
    private String title;
    private String type;
    private Dimensions dimensions;
    private int videoQuality;
    private int durationInSeconds;

    public Post(int id, User author, String content) {
        this.id = id;
        this.author = author;
        this.date = new Date();
        this.comments = new ArrayList<>();
        this.content = content;
        this.title = "";
        this.type = "Text";
    }

    public Post(int id, User author, String content, String title, Dimensions dimensions) {
        this(id, author, content);
        this.title = title;
        this.dimensions = dimensions;
        this.type = "Image";
    }

    public Post(int id, User author, String content, String title, int videoQuality, int durationInSeconds) {
        this(id, author, content);
        this.title = title;
        this.videoQuality = videoQuality;
        this.durationInSeconds = durationInSeconds;
        this.type = "Video";
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public int getVideoQuality() {
        return videoQuality;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }
}

