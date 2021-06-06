package com.RedditApp.Reddit.Controller;


import com.RedditApp.Reddit.Model.Comment;
import com.RedditApp.Reddit.Model.Post;
import com.RedditApp.Reddit.Model.User;
import com.RedditApp.Reddit.Service.CommentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class CommentController {

    @Autowired
    public CommentService commentService;
    
    @PostMapping("{Userid}/post/{postId}/comment/create")
    public Comment createcomment(@PathVariable("postId") Integer postId,@PathVariable("Userid") String Userid, @RequestBody String data) throws JsonProcessingException {

        Comment comment=new ObjectMapper().readValue(data,Comment.class);
        comment.setTIMESTAMP(LocalTime.now());
        comment.setUser(new User(Userid));
        comment.setPost(new Post(postId));
        Comment comment1=commentService.addcomment(comment,postId);
        if(comment1==null)
        {
            return null;
        }
        return comment1;

    }

    @GetMapping("/post/{postId}/comments")
    public List<Comment> allcomments(@PathVariable("postId") Integer postId)
    {
        return commentService.getallcomments(postId);
    }

}
