package com.example.videocallapp.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/v1/user")
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<String> home() {
    return ResponseEntity.ok("Hello Word!");
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> allUsers() {
    return ResponseEntity.ok(userService.findAllUsers());
  }

  @PostMapping("/register")
  public void userRegister(@RequestBody User user) {
    userService.register(user);
  }

  @PostMapping("/login")
  public ResponseEntity<UserDTO> loginUser(@RequestBody User user) {
    return ResponseEntity.ok(userService.login(user));
  }

  @PostMapping("/logout/{email}")
  public void userLogout(@PathVariable String email) {
    userService.logout(email);
  }

}
