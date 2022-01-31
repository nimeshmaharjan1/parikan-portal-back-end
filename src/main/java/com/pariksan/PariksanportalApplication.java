package com.pariksan;

import com.pariksan.model.Role;
import com.pariksan.model.User;
import com.pariksan.model.UserRole;
import com.pariksan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PariksanportalApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PariksanportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The application is running...");
		// User user = new User();
		// user.setFirstName("Nimesh");
		// user.setLastName("Maharjan");
		// user.setUsername("nimeshmaharjan1");
		// user.setPassword(this.bCryptPasswordEncoder.encode("123456"));
		// user.setEmail("nimesh@gmail.com");
		// user.setProfile("default.png");

		// Role role1 = new Role();
		// role1.setRoleId(44L);
		// role1.setRoleName("ADMIN");
		
		// Set<UserRole> userRoleSet = new HashSet<>();
		// UserRole userRole = new UserRole();

		// userRole.setRole(role1);
		// userRole.setUser(user);
		// userRoleSet.add(userRole);

		// User user1 = this.userService.createUser(user, userRoleSet);
		// System.out.println(user1.getUsername());

	}
}
