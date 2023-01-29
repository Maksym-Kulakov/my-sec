package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.exception.AuthenticationException;
import org.example.model.Role;
import org.example.model.User;
import org.example.service.AuthService;
import org.example.service.UserService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(Role.USER);
        user = userService.create(user);
        return user;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User user = userService.findByEmail(email);
        String encodedPassword = passwordEncoder.encode(password);
        if (user == null || user.getPassword().equals(encodedPassword)) {
            throw new AuthenticationException("Incorrect username or password!!!");
        }
        return user;
    }
}
