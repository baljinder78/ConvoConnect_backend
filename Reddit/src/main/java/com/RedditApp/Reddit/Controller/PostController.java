package com.RedditApp.Reddit.Controller;


import com.RedditApp.Reddit.Model.Comment;
import com.RedditApp.Reddit.Model.Post;
import com.RedditApp.Reddit.Model.User;
import com.RedditApp.Reddit.Repo.UserRepo;
import com.RedditApp.Reddit.Service.PostService;
import com.RedditApp.Reddit.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class PostController {

    @Autowired
    public PostService postService;

    @Autowired
    public UserService userService;


    @PostMapping("/post/{userId}/create")
    public Post createpost(@RequestBody String data,@PathVariable String userId) throws JsonProcessingException {
        Post post=new Post();
        post=new ObjectMapper().readValue(data,Post.class);
        post.setTIMESTAMP(LocalTime.now());
        post.setUser(new User(userId));
        Post post1=postService.createpost(post);
        if(post1==null)
        {
            return null;
        }
        return post1;
    }

    @GetMapping("/post/all")
    public List<Post> allpsot()
    {
        return postService.allpostslist();
    }
    @GetMapping("/post/{postid}")
    public Post getpost(@PathVariable("postid") Integer id)
    {
        return postService.getpost(id);
    }
}
