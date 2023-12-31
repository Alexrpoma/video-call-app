package com.example.videocallapp.user;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<User, UserDTO> {

  @Override
  public UserDTO apply(User user) {
    return UserDTO.builder()
        .username(user.getUsername())
        .email(user.getEmail())
        .status(user.getStatus())
        .build();
  }
}
