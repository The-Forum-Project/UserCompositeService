package com.example.usercompositeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients({"com.example.usercompositeservice.service.remote"})
@SpringBootApplication
public class UserCompositeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCompositeServiceApplication.class, args);
	}

}
