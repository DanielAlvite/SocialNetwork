package org.campusdual;
import java.util.ArrayList;
import java.util.List;
public class User {

    private String name;
    private List<User> follows;
    private List<Post> posts;

    public User(String name){
        this.name=name;
        this.follows=new ArrayList<>();
        this.posts = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void followUser(User user){
        follows.add(user);
    }

    public void unFollowUser(User user){
        follows.remove(user);
    }
    public void createPost(Post post) {
        posts.add(post);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }
    public List<Post> getPosts() {
        return posts;
    }
    public List<Comment> getComments() {
        List<Comment> comments = new ArrayList<>();
        for (Post post : posts) {
            comments.addAll(post.getComments());
        }
        return comments;
    }
}
