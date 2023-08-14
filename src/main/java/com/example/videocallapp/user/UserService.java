package com.example.videocallapp.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
  private static final List<User> USERS_LIST = new ArrayList<>();

  public void register(User user) {
    if(USERS_LIST.contains(user)) {
      throw new RuntimeException("Email user is taken!");
    }
    user.setStatus(UserStatus.ONLINE);
    USERS_LIST.add(user);
  }

  public User login(User user) {
    int userIndex = IntStream.range(0, USERS_LIST.size())
        .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("User not found!"));
    User userFound = USERS_LIST.get(userIndex);
    if(!userFound.getPassword().equals(user.getPassword())) {
      throw new RuntimeException("Password incorrect");
    }
    userFound.setStatus(UserStatus.ONLINE);
    return userFound;
  }

  public void logout(String email) {
    int userIndex = IntStream.range(0, USERS_LIST.size())
        .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("User not found!"));
    USERS_LIST.get(userIndex).setStatus(UserStatus.OFFLINE);
  }

  public List<User> findAllUsers() {
    return USERS_LIST;
  }
}
