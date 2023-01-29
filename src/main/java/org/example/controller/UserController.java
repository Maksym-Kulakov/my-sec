package org.example.controller;

import org.example.model.dto.UserRequestDto;
import org.example.model.dto.UserResponseDto;
import org.example.model.mapper.UserMapper;
import org.example.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/add")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto) {
        return userMapper.toDto(userService.create(userMapper.toModel(requestDto)));
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        return userMapper.toDto(userService.get(id));
    }

    @GetMapping
    public String getAuthDetails(Authentication authentication) {
        return authentication.getName();
    }
}
