package com.example.videocallapp;

import com.example.videocallapp.user.User;
import com.example.videocallapp.user.UserService;
import com.example.videocallapp.user.UserStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoCallAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoCallAppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return  args -> {
			userService.register(User.builder()
							.username("Anna")
							.email("anna@gmail.com")
							.password("123123")
							.build());
			userService.register(User.builder()
							.username("John")
							.email("john@outlook.com")
							.password("123123")
							.build());
			userService.register(User.builder()
							.username("Maria")
							.email("maria@gmail.com")
							.password("123123")
							.build());
		};
	}

}
