package com.lcss.eduCov_backend.controller;

import com.lcss.eduCov_backend.model.User;
import com.lcss.eduCov_backend.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return this.userService.fetchAllPosts();
    }

    @PostMapping(value = "/newUser")
    public void addNewUser(@RequestBody User newUser) {
        this.userService.addNewUser(newUser);
    }

    @PutMapping(value = "/updateUser")
    public void updateUser(Long userId) {
        this.userService.updatePost(userId);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(Long userId) {
        this.userService.deletePost(userId);
    }

}
