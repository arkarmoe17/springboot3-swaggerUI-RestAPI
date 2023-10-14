package com.learning.springboot3swaggerui.service;

import com.learning.springboot3swaggerui.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
