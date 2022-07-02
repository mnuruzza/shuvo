package com.lcss.eduCov_backend.service;

import com.lcss.eduCov_backend.model.User;
import com.lcss.eduCov_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void addNewUser(User newUser) {
        this.userRepository.save(newUser);
    }

    public List<User> fetchAllPosts() {
        return this.userRepository.findAll();
    }

    public Optional<User> getById(Long postId) {
        return this.userRepository.findById(postId);
    }

    public void deletePost(Long postId) {
        if (this.getById(postId).isPresent()) {
            this.userRepository.deleteById(postId);
        }
        throw new RuntimeException();
    }

    public void updatePost(Long postId) {

    }
}
