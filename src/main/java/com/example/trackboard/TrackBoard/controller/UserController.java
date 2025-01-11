package com.example.trackboard.TrackBoard.controller;

import com.example.trackboard.TrackBoard.entity.User;
import com.example.trackboard.TrackBoard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User userDetails) {
        return userService.createUser(userDetails);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User userDetails) {
        return userService.updateUser(userDetails);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}
