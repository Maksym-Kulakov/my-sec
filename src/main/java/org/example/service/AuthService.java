package org.example.service;

import org.example.exception.AuthenticationException;
import org.example.model.User;

public interface AuthService {
    User register(String email, String password);

    User login(String email, String password) throws AuthenticationException;
}
