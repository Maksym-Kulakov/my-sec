package org.example.model.mapper;

import org.example.model.Role;
import org.example.model.User;
import org.example.model.dto.UserRequestDto;
import org.example.model.dto.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User,UserRequestDto,UserResponseDto> {
    @Override
    public User toModel(UserRequestDto userRequestDto) {
        return User.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .age(userRequestDto.getAge())
                .password(userRequestDto.getPassword())
                .role(Role.valueOf(userRequestDto.getRole()))
                .build();
    }

    @Override
    public UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .role(user.getRole().name())
                .build();
    }
}
