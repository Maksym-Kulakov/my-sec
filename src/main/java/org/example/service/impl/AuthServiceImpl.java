package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.AuthService;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    @Override
    public User register(String email, String password, String role) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.valueOf(role));
        userService.create(user);
        return user;
    }


}
