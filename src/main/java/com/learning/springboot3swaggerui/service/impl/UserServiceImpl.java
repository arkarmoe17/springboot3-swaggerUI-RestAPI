package com.learning.springboot3swaggerui.service.impl;

import com.learning.springboot3swaggerui.exceptions.UserServiceException;
import com.learning.springboot3swaggerui.model.User;
import com.learning.springboot3swaggerui.model.constants.Gender;
import com.learning.springboot3swaggerui.model.request.UserRequest;
import com.learning.springboot3swaggerui.repository.UserRepository;
import com.learning.springboot3swaggerui.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUserInfo(UserRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(() -> new UserServiceException("User id is not found"));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(ObjectUtils.isNotEmpty(request.getGender()) ? request.getGender() : Gender.OTHER);
        return user;
    }
}
