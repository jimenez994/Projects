package com.zeus.LoginGF;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class LoginGfApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginGfApplication.class, args);
	}
}
