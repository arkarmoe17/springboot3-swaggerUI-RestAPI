package com.learning.springboot3swaggerui.auth;

import com.learning.springboot3swaggerui.config.JwtService;
import com.learning.springboot3swaggerui.model.User;
import com.learning.springboot3swaggerui.model.constants.Role;
import com.learning.springboot3swaggerui.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        //TODO: check already register or not
        var user = User
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        // token
        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // userInfo
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        log.info("userInfo: {}",user);

        var jwtToken = jwtService.generateToken(user);
        log.info("Token:{}",jwtToken);

        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }
}
