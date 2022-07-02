package com.lcss.eduCov_backend.service;

import com.github.javafaker.Faker;
import com.lcss.eduCov_backend.model.Post;
import com.lcss.eduCov_backend.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    public void addNewPost(Post newPost) {
        this.postRepository.save(newPost);
    }

    public List<Post> fetchAllPosts() {
        return this.postRepository.findAll();
    }

    public Optional<Post> getById(Long postId) {
        return this.postRepository.findById(postId);
    }

    public void deletePost(Long postId) {
        if (this.getById(postId).isPresent()) {
            this.postRepository.deleteById(postId);
        }
        throw new RuntimeException();
    }

    public void updatePost(Post newPost, Long postId) {
        if (this.getById(postId).isPresent()) {
            Post existingPost = this.getById(postId).get();

            existingPost.setTitle(newPost.getTitle());
            existingPost.setText(newPost.getText());
            existingPost.setAuthor(newPost.getAuthor());

            this.addNewPost(existingPost);
        }
    }

    @PostConstruct
    public void generateFakePosts() {
        Faker faker = new Faker();

        Post randomPost = Post.builder()
                .author(faker.artist().name())
                .postId(faker.number().randomNumber())
                .text(faker.lorem().sentence(25))
                .title(faker.crypto().toString())
                .build();
        for (int i = 0; i <= 8; i++) {
            this.addNewPost(randomPost);
        }
    }
}
