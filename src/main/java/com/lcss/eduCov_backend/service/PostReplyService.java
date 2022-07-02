package com.lcss.eduCov_backend.service;

import com.lcss.eduCov_backend.model.PostReply;
import com.lcss.eduCov_backend.repository.PostReplyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostReplyService {
    @Autowired
    private PostReplyRepository postReplyRepository;

    public void addNewReply(PostReply newPostReply) {
        this.postReplyRepository.save(newPostReply);
    }

    public List<PostReply> fetchAllPosts() {
        return this.postReplyRepository.findAll();
    }

    public Optional<PostReply> getById(Long postId) {
        return this.postReplyRepository.findById(postId);
    }

    public void deletePost(Long postId) {
        if (this.getById(postId).isPresent()) {
            this.postReplyRepository.deleteById(postId);
        }
        throw new RuntimeException();
    }

    public void updatePost(Long postId) {

    }
}
