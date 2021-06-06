package com.RedditApp.Reddit.Controller;


import com.RedditApp.Reddit.Model.User;
import com.RedditApp.Reddit.Service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalTime;
import java.util.Optional;

import static java.time.LocalTime.now;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    public UserService userService;

    // Signing user
    @PostMapping("/user/signIn")
    public String sgnin(@RequestBody String data) throws JsonProcessingException {
        User user= new ObjectMapper().readValue(data,User.class);
        if (userService.CheckUser(user))
        {
            return "User Singed in successfully";
        }
        else {
            return "Not found";
        }
    }

    // Signout user
    @PostMapping("/user/signout")
    public String sout()
    {
        return "sout";
    }

    @PostMapping("/user/create/")
    public String createuser(@RequestBody String data) throws JsonProcessingException {
        User user=new User();
        user=new ObjectMapper().readValue(data,User.class);
        user.setTIMESTAMP(LocalTime.now());
        if(userService.CreateUser(user))
        {
            return user.getUserId();
        }
        else {
            return "false";
        }
    }



    @DeleteMapping("/user/delete/{userId}")
    public String dltu(@PathVariable  String userId)
    {
        if(userService.Deleteuser(userId))
        {
            return "USER deleted successfully";
        }

        return "User not deleted";
    }

}
