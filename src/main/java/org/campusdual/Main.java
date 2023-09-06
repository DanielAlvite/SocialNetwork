package org.campusdual;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.createUser("TestUser1");
        socialNetwork.createUser("TestUser2");
        while (true) {
            System.out.println("***************************SOCIAL_NETWORK***************************");
            System.out.println("*                                                                  *");
            System.out.println("* WELCOME TO SOCIAL_NETWORK                                        *");
            System.out.println("* RULES:                                                           *");
            System.out.println("* Write a number between 1 and 12 depending on what you want to do *");
            System.out.println("* Any other number will be discarded as an option                  *");
            System.out.println("*                                                                  *");
            System.out.println("*                    __MENU__                                      *");
            System.out.println("*                __CREATE OPTIONS__                                *");
            System.out.println("*                1.ADD A USER                                      *");
            System.out.println("*                2.MAKE A POST                                     *");
            System.out.println("*                3.ADD A COMMENT                                   *");
            System.out.println("*                                                                  *");
            System.out.println("*                __FOLLOW OPTIONS__                                *");
            System.out.println("*                4.START FOLLOWING A USER                          *");
            System.out.println("*                5.UNFOLLOW A USER                                 *");
            System.out.println("*                                                                  *");
            System.out.println("*                __DELETE OPTIONS__                                *");
            System.out.println("*                6.DELETE A USER                                   *");
            System.out.println("*                7.DELETE A POST                                   *");
            System.out.println("*                8.DELETE A COMMENT                                *");
            System.out.println("*                                                                  *");
            System.out.println("*                __LIST/SHOW OPTIONS__                             *");
            System.out.println("*                9.LIST ALL REGISTERED USERS                       *");
            System.out.println("*                10.LIST ALL POSTS OF A USER                       *");
            System.out.println("*                11.LIST ALL COMMENTS OF A USER                    *");
            System.out.println("*                12.SHOW NUMBER OF COMMENTS ON A POST              *");
            System.out.println("*                                                                  *");
            System.out.println("*                13.EXIT                                           *");
            System.out.println("*                                                                  *");
            System.out.println("********************************************************************");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("ENTER A NAME FOR THE NEW USER: ");
                    String newUser = scanner.nextLine();
                    socialNetwork.createUser(newUser);
                    System.out.println("USER _" + newUser + "_ ADDED");
                    break;

                case 2:
                    System.out.println("ENTER THE USERNAME OF THE AUTHOR OF THE POST: ");
                    String author = scanner.nextLine();
                    System.out.println("ENTER THE CONTENT TYPE (Text, Image, or Video): ");
                    String contentType = scanner.nextLine();

                    if (contentType.equalsIgnoreCase("Text")) {
                        System.out.println("ENTER THE CONTENT OF THE POST: ");
                        String content = scanner.nextLine();
                        socialNetwork.createPost(author, content);
                        System.out.println("POST CREATED BY: " + author);
                    } else if (contentType.equalsIgnoreCase("Image")) {
                        System.out.println("ENTER THE TITLE OF THE IMAGE: ");
                        String title = scanner.nextLine();
                        System.out.println("ENTER THE WIDTH OF THE IMAGE: ");
                        int width = scanner.nextInt();
                        System.out.println("ENTER THE HEIGHT OF THE IMAGE: ");
                        int height = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        socialNetwork.createImagePost(author, title, width, height);
                        System.out.println("IMAGE POST CREATED BY: " + author);
                    } else if (contentType.equalsIgnoreCase("Video")) {
                        System.out.println("ENTER THE TITLE OF THE VIDEO: ");
                        String title = scanner.nextLine();
                        System.out.println("ENTER THE QUALITY OF THE VIDEO: ");
                        int videoQuality = scanner.nextInt();
                        System.out.println("ENTER THE DURATION OF THE VIDEO (in seconds): ");
                        int durationInSeconds = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline
                        socialNetwork.createVideoPost(author, title, videoQuality, durationInSeconds);
                        System.out.println("VIDEO POST CREATED BY: " + author);
                    } else {
                        System.out.println("Invalid content type. Please enter Text, Image, or Video.");
                    }
                    break;

                case 3:
                    System.out.println("ENTER THE ID OF THE POST TO COMMENT ON: ");
                    int postId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("ENTER THE NAME OF THE USER MAKING THE COMMENT: ");
                    String commenter = scanner.nextLine();
                    System.out.println("ENTER THE COMMENT: ");
                    String commentContent = scanner.nextLine();
                    socialNetwork.createComment(postId, commenter, commentContent);
                    System.out.println("COMMENT CREATED BY: " + commenter);
                    break;

                case 4:
                    System.out.println("ENTER THE NAME OF THE FOLLOWER: ");
                    String followerName = scanner.nextLine();
                    System.out.println("ENTER THE NAME OF THE USER TO START FOLLOWING: ");
                    String followedUserName = scanner.nextLine();
                    socialNetwork.followUser(followerName, followedUserName);
                    System.out.println(followerName + " STARTED FOLLOWING " + followedUserName);
                    break;

                case 5:
                    System.out.println("ENTER THE NAME OF THE FOLLOWER: ");
                    String follower = scanner.nextLine();
                    System.out.println("ENTER THE NAME OF THE USER TO UNFOLLOW: ");
                    String unfollowedUser = scanner.nextLine();
                    socialNetwork.unfollowUser(follower, unfollowedUser);
                    System.out.println(follower + " UNFOLLOWED " + unfollowedUser);
                    break;

                case 6:
                    System.out.println("ENTER THE NAME OF THE USER TO DELETE: ");
                    String userToDelete = scanner.nextLine();
                    socialNetwork.deleteUser(userToDelete);
                    System.out.println("USER " + userToDelete + " DELETED");
                    break;

                case 7:
                    System.out.println("ENTER THE ID OF THE POST TO DELETE: ");
                    int postToDelete = scanner.nextInt();
                    scanner.nextLine();
                    socialNetwork.deletePost(postToDelete);
                    System.out.println("POST WITH ID " + postToDelete + " DELETED");
                    break;

                case 8:
                    System.out.println("ENTER THE ID OF THE POST CONTAINING THE COMMENT: ");
                    int postIdToDeleteComment = scanner.nextInt();
                    System.out.println("ENTER THE ID OF THE COMMENT TO DELETE: ");
                    int commentIdToDelete = scanner.nextInt();
                    socialNetwork.deleteComment(postIdToDeleteComment, commentIdToDelete);
                    System.out.println("COMMENT DELETED");
                    break;

                case 9:
                    System.out.println("ALL REGISTERED USERS : ");
                    for (User user : socialNetwork.getUsers().values()) {
                        System.out.println(user.getName());
                    }
                    break;

                case 10:
                    System.out.println("ENTER THE USERNAME TO LIST ALL POSTS: ");
                    String usernameToListPosts = scanner.nextLine();
                    User userToFindPosts = socialNetwork.getUserByName(usernameToListPosts);

                    if (userToFindPosts != null) {
                        List<Post> userPosts = socialNetwork.getUserPosts(usernameToListPosts);

                        if (!userPosts.isEmpty()) {
                            System.out.println("POSTS BY " + usernameToListPosts + ":");
                            for (Post post : userPosts) {
                                String postInfo = "";

                                if (post.getType().equalsIgnoreCase("Text")) {
                                    postInfo = " (Text Post)";
                                } else if (post.getType().equalsIgnoreCase("Image")) {
                                    Dimensions dimensions = post.getDimensions();
                                    postInfo = " (POST TYPE : IMAGE - POST TITLE : " + post.getTitle() + " , DIMENSIONS : " +
                                            dimensions.getWidth() + "x" + dimensions.getHeight() + ")";
                                } else if (post.getType().equalsIgnoreCase("Video")) {
                                    postInfo = " (POST TYPE : VIDEO - POST TITLE : " + post.getTitle() + ", QUALITY : " +
                                            post.getVideoQuality() + ", DURATION : " + post.getDurationInSeconds() + " seconds)";
                                }

                                System.out.println("Posted by " + usernameToListPosts +
                                        postInfo + " at " + post.getDate() +
                                        ": " + post.getContent());
                            }
                        } else {
                            System.out.println(usernameToListPosts + " has no posts.");
                        }
                    } else {
                        System.out.println("User " + usernameToListPosts + " not found.");
                    }
                    break;

                case 11:
                    System.out.println("ENTER THE USERNAME TO LIST ALL COMMENTS: ");
                    String userToFindComments = scanner.nextLine();
                    List<Comment> userComments = socialNetwork.getUserComments(userToFindComments);
                    if (userComments.isEmpty()) {
                        System.out.println(userToFindComments + " HAS NO COMMENTS YET");
                    } else {
                        System.out.println("ALL COMMENTS OF " + userToFindComments + ":");
                        for (Comment comment : userComments) {
                            System.out.println("COMMENT ID: " + comment.getId() + ", CONTENT: " + comment.getText());
                        }
                    }
                    break;

                case 12:
                    System.out.println("ENTER THE ID OF THE POST TO VIEW COMMENTS: ");
                    int postIdToView = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline

                    Post postToView = socialNetwork.getPostById(postIdToView);

                    if (postToView != null) {
                        System.out.println("Number of comments on Post #" + postIdToView + ": " + postToView.getComments().size());

                        System.out.println("NUMBER OF COMMENTS ON POST #" + postIdToView + ":");
                        for (Comment comment : postToView.getComments()) {
                            System.out.println("COMMENT BY " + comment.getOwner().getName() + " ON " + comment.getDate() + ":");
                            System.out.println(comment.getText());
                            System.out.println("--------");
                        }
                    } else {
                        System.out.println("POST WITH ID #" + postIdToView + " NOT FOUND.");
                    }
                    break;

                case 13:
                    System.out.println("EXITING THE PROGRAM");
                    scanner.close();
                    System.exit(0);
                    break;


                default:
                    System.out.println("INVALID OPTION , PLEASE SELECT A VALID OPTION BETWEEN 1 AND 12");
        }
    }
    }
}