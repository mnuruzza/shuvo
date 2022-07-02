package com.lcss.eduCov_backend.controller;

import com.lcss.eduCov_backend.model.PostReply;
import com.lcss.eduCov_backend.service.PostReplyService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class PostReplyController {
    @Autowired
    private PostReplyService postReplyService;

    @GetMapping(value = "/replies")
    public List<PostReply> getAllReplies() {
        return this.postReplyService.fetchAllPosts();
    }

    @PostMapping(value = "/newReply")
    public void addNewReply(@RequestBody PostReply newPostReply) {
        this.postReplyService.addNewReply(newPostReply);
    }

    @PutMapping(value = "/updateReply")
    public void updateReply(Long replyId) {
        this.postReplyService.updatePost(replyId);
    }

    @DeleteMapping(value = "/deleteReply")
    public void deleteReply(Long replyId) {
        this.postReplyService.deletePost(replyId);
    }
}
