package com.pariksan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PariksanportalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PariksanportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Starting");
	}
}
