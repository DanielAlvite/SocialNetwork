package org.campusdual;
import java.util.Date;
public class Comment {
    private int id;
    private String text;
    private Date date;
    private User owner;

    private static int commentIdCounter = 1;

    public Comment(String text,User owner){
        this.id = commentIdCounter++;
        this.text = text;
        this.date = new Date();
        this.owner = owner;
    }
    public int getId() {
        return id;
    }

    public String getText(){
        return text;
    }

    public Date getDate(){
        return date;
    }

    public User getOwner(){
        return owner;
    }
}
