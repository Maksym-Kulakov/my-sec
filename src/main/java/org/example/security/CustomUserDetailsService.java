package org.example.security;

import org.example.model.User;
import org.example.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static org.springframework.security.core.userdetails.User.withUsername;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User userFmDb = userService.findByEmail(email);
        UserBuilder userBuilder;
        userBuilder = withUsername(email);
        userBuilder.password(userFmDb.getPassword());
        userBuilder.roles(userFmDb.getRole().name());
        return userBuilder.build();
    }
}
