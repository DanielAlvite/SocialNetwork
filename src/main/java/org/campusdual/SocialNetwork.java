package org.campusdual;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SocialNetwork {
    private Map<String,User>users;
    private List<Post>posts;
    private int postIdCounter;

    public SocialNetwork(){
        this.users = new HashMap<>();
        this.posts = new ArrayList<>();
        this.postIdCounter = 1;
    }
    public void createUser(String username){
        User newUser = new User(username);
    }
    public void followUser(String followerName,String followedName){
        User follower = users.get(followerName);
        User followed = users.get(followedName);

        if (follower != null && followed != null){
            follower.followUser(followed);
        }
    }
    public void unfollowUser(String followerName,String followedName){
        User follower = users.get(followerName);
        User followed = users.get(followedName);

        if(follower != null && followed != null){
            follower.unFollowUser(followed);
        }
    }

    public void createPost(String username,String content){
        User user = users.get(username);

        if(user != null){
            Post newPost = new Post(postIdCounter++,user,content);
            user.createPost(newPost);
            posts.add(newPost);
        }
    }
    public void deletePost(int postId) {
        Post postToRemove = null;
        for (Post post : posts) {
            if (post.getId() == postId) {
                postToRemove = post;
                break;
            }
        }
        if (postToRemove != null) {
            posts.remove(postToRemove);
        }
    }
    public List<Post> getUserPosts(String username) {
        User user = users.get(username);
        List<Post> userPosts = new ArrayList<>();

        if (user != null) {
            for (Post post : posts) {
                if (post.getAuthor().getName().equals(username)) {
                    userPosts.add(post);
                }
            }
        }

        return userPosts;
    }

    public List<Comment> getUserComments(String username){
        User user = users.get(username);
        List<Comment> userComments = new ArrayList<>();

        if(user != null){
            for(Post post : posts){
                for(Comment comment : post.getComments()){
                    if(comment.getOwner().getName().equals(username)){
                        userComments.add(comment);
                    }
                }
            }
        }
        return userComments;
    }

    public int getCommentCount(int postId){
        for(Post post : posts){
            if(post.getId()== postId){
                return post.getComments().size();
            }
        }
        return 0;
    }


}
