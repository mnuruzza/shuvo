package com.lcss.eduCov_backend.service;

import com.lcss.eduCov_backend.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

     List<Post> fetchAllPosts();

     Optional<Post> getById(Long postId);

     void deletePost(Long postId);

     void updatePost(Post newPost, Long postId);
}
