package com.lcss.eduCov_backend.controller;

import com.lcss.eduCov_backend.model.Post;
import com.lcss.eduCov_backend.service.PostServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class PostController {
    @Autowired
    private PostServiceImpl postService;

    @GetMapping(value = "/posts")
    public List<Post> getAllPosts() {
        return this.postService.fetchAllPosts();
    }

    @PostMapping(value = "/newPost")
    public void addNewPost(@RequestBody Post newPost) {
        this.postService.addNewPost(newPost);
    }

    @PutMapping(value = "/updatePost")
    public void updatePost(@RequestBody Post newPost, @PathVariable Long postId) {
        this.postService.updatePost(newPost,postId);
    }

    @GetMapping(value = "/deletePost")
    public void deletePost(@RequestParam Long postId) {
        this.postService.deletePost(postId);
    }

}