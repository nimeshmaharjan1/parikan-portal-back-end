package com.pariksan;

import com.pariksan.model.Role;
import com.pariksan.model.User;
import com.pariksan.model.UserRole;
import com.pariksan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PariksanportalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(PariksanportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The application is running...");

	}
}
