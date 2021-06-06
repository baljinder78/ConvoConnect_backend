package com.RedditApp.Reddit.Service;

import com.RedditApp.Reddit.Model.User;
import com.RedditApp.Reddit.Repo.UserRepo;
import com.RedditApp.Reddit.Repo.UserRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public boolean CreateUser(User user)
    {
        if(userRepo.existsById(user.getUserId()))
        {
            return false;
        }
        else
        {
            try {
                userRepo.save(user);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return false;
            }
            return true;
        }
    }

    public boolean CheckUser(User user)
    {
        if(userRepo.existsById(user.getUserId()))
        {
            try
            {
                Optional<User> user1=this.userRepo.findById(user.getUserId());
                if(user1.isPresent()?user1.get().getPassword().equals(user.getPassword()):false)
                {
                    return true;
                }
                else {
                    return false;
                }
            }
            catch (Exception e)
            {
                return false;
            }
        }
        else
        {
            return false;
        }

    }

    public boolean Deleteuser(String Userid)
    {
        try{
            userRepo.deleteById(Userid);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public User finduser(String id)
    {
        Optional<User> user=userRepo.findById(id);
        return user.isPresent()?user.get():user.get();
    }

}
