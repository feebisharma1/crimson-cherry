package com.allstate.crimsoncherry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrimsonCherryApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrimsonCherryApplication.class, args);
		System.out.println("Ready to process movie API requests!");
	}

}
