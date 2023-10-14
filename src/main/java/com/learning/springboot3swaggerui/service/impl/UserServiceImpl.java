package com.learning.springboot3swaggerui.service.impl;

import com.learning.springboot3swaggerui.model.User;
import com.learning.springboot3swaggerui.repository.UserRepository;
import com.learning.springboot3swaggerui.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
}
