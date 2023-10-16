package com.learning.springboot3swaggerui.service;

import com.learning.springboot3swaggerui.model.User;
import com.learning.springboot3swaggerui.model.request.UserRequest;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User updateUserInfo(UserRequest request);
}
