package com.example.videocallapp.user;

import lombok.Builder;

@Builder
public record UserDTO(
    String username,
    String email,
    UserStatus status) {
}
