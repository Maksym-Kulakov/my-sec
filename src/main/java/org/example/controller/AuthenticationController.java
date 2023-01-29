package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.exception.AuthenticationException;
import org.example.model.User;
import org.example.model.dto.UserRequestDto;
import org.example.model.dto.UserResponseDto;
import org.example.model.mapper.UserMapper;
import org.example.security.jwt.JwtTokenProvider;
import org.example.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthService authService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = authService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
        return userMapper.toDto(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object>login(@RequestBody UserRequestDto userRequestDto)
            throws AuthenticationException {
        User user = authService.login(userRequestDto.getEmail(), userRequestDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRole().name());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
