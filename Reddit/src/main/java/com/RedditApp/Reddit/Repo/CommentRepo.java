package com.RedditApp.Reddit.Repo;


import com.RedditApp.Reddit.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {

    @Query("SELECT new Comment (c.commentId,c.comment,c.TIMESTAMP,c.post.postId,c.user.UserId) from Comment c where c.commentId=:id")
    public Comment findByCommentId(Integer id);

    @Query("SELECT new Comment (c.commentId,c.comment,c.TIMESTAMP,c.post.postId,c.user.UserId) from Comment c where c.post.postId=:id ")
    public List<Comment> findAllByPostId(Integer id);
}
