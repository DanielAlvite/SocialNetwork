package org.campusdual;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Post {
    private Date date;
    private List <Comment> comments;

    public Post(Date date){
        this.date = date;
        this.comments = new ArrayList<>();
    }
    public void addComment(Comment comment) {
        comments.add(comment);
    }
    public List<Comment> getComments(){
        return comments;
    }
}

