package org.example.service;

import org.example.model.User;

public interface AuthService {
    User register(String email, String password, String role);
}
