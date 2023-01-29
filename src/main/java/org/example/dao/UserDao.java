package org.example.dao;

import java.util.Optional;
import org.example.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
