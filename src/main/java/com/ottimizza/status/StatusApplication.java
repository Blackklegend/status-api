package com.ottimizza.status;

import java.util.LinkedHashMap;

import com.ottimizza.status.Model.Body;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StatusApplication {

	public static LinkedHashMap<String, Body> rotaInfoLog = new LinkedHashMap<String, Body>();

	public static void main(String[] args) {
		SpringApplication.run(StatusApplication.class, args);
	}

}
