package com.RedditApp.Reddit.Service;


import com.RedditApp.Reddit.Model.Comment;
import com.RedditApp.Reddit.Model.Post;
import com.RedditApp.Reddit.Model.User;
import com.RedditApp.Reddit.Repo.CommentRepo;
import com.RedditApp.Reddit.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    public CommentRepo commentRepo;




        public Comment addcomment(Comment comment,Integer postid)
        {
            comment.setPost(new Post(postid));
            try{
                Comment comment1=commentRepo.save(comment);
                Comment comment2=commentRepo.findByCommentId(comment1.getCommentId());
                return comment2;
            }
            catch (Exception ee)
            {
                System.out.println(ee);
                return null;
            }

        }

        public List<Comment> getallcomments(Integer postid)
        {
            return commentRepo.findAllByPostId(postid);
        }

}
