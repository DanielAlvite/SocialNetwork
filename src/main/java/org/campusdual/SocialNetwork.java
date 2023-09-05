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
    public void createUser(String username) {
        User newUser = new User(username);
        users.put(username, newUser);
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

    public void deleteUser(String username) {
        User userToRemove = users.get(username);
        if (userToRemove != null) {
            for (Post post : userToRemove.getPosts()) {
                posts.remove(post);
            }
            users.remove(username);
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

    public Post getPostById(int postId) {
        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }
        return null;
    }

    public User getUserByName(String userName) {
        return users.get(userName);
    }

    public void createComment(int postId, String commenterName, String commentContent) {
        Post post = getPostById(postId);
        User commenter = getUserByName(commenterName);

        if (post != null && commenter != null) {
            Comment comment = new Comment(commentContent, commenter);
            post.addComment(comment);
        } else {
            System.out.println("POST NOT FOUND");
        }
    }

    public void deleteComment(int postId, int commentId) {
        Post post = getPostById(postId);
        if (post != null) {
            List<Comment> comments = post.getComments();
            Comment commentToRemove = null;
            for (Comment comment : comments) {
                if (comment.getId() == commentId) {
                    commentToRemove = comment;
                    break;
                }
            }
            if (commentToRemove != null) {
                comments.remove(commentToRemove);
            }
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

    public Map<String, User> getUsers() {
        return users;
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
