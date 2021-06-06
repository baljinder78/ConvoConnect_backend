package com.RedditApp.Reddit.Model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comments")
public class Comment {

    //1.	UserId				postId					commentId
//2.	userName			postTitle				comment
//3.	password			postDesc				post_id(FK)
//4.	email				TIMESTAMP				user_id(FK)
//5.	DOB				user_id(FK)				TIMESTAMP
//6.	TIMESTAMP

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer commentId;

    public String comment;

    public LocalTime TIMESTAMP;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Comment() {
    }

    public Comment(Integer commentId) {
        this.commentId = commentId;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment(Integer commentId, String comment, LocalTime TIMESTAMP, Integer postid, String userid) {
        this.commentId = commentId;
        this.comment = comment;
        this.TIMESTAMP = TIMESTAMP;
        this.post = new Post(postid);
        this.user = new User(userid);
    }


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalTime getTIMESTAMP() {
        return TIMESTAMP;
    }

    public void setTIMESTAMP(LocalTime TIMESTAMP) {
        this.TIMESTAMP = TIMESTAMP;
    }

    public Integer getPost() {
        return post.getPostId();
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getUser() {
        return user.getUserId();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
