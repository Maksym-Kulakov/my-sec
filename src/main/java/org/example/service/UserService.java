package org.example.service;

import org.example.model.User;

public interface UserService {
    User create(User user);

    User get(Long id);

    User findByEmail(String email);
}
