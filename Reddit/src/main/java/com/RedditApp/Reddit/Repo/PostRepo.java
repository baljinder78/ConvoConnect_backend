package com.RedditApp.Reddit.Repo;

import com.RedditApp.Reddit.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Post,Integer> {

    @Query("select new Post (p.postId,p.postTitle,p.postDesc,p.TIMESTAMP,p.user.UserId) from Post p")
    public List<Post> findAllByPost();

    @Query("select new Post (p.postId,p.postTitle,p.postDesc,p.TIMESTAMP,p.user.UserId) from Post p where p.postId=:postid")
    public Post findPostByPostId(Integer postid);
}
