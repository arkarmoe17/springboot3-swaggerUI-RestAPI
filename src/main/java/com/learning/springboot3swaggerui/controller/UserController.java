package com.learning.springboot3swaggerui.controller;

import com.learning.springboot3swaggerui.model.User;
import com.learning.springboot3swaggerui.model.request.UserRequest;
import com.learning.springboot3swaggerui.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // Fetch all users
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    // Update User Info
    @PutMapping
    public ResponseEntity<User> updateUserInfo(@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.updateUserInfo(request));
    }


}
