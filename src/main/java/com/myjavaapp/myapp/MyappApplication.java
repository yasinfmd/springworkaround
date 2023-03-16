package com.myjavaapp.myapp;

import com.myjavaapp.myapp.service.imp.FileStorageService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyappApplication implements CommandLineRunner {
	// logger
	@Autowired
	FileStorageService service;
	public static void main(String[] args) {
		SpringApplication.run(MyappApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//    storageService.deleteAll();
		System.out.println("Folder creating");
		service.init();
	}

}