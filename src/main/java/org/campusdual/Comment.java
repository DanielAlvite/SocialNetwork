package org.campusdual;
import java.util.Date;
public class Comment {
    private String text;
    private Date date;
    private User owner;

    public Comment(String text,User owner){
        this.text = text;
        this.date = new Date();
        this.owner = owner;
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
