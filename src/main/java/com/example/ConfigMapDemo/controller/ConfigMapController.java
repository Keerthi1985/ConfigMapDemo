package com.example.ConfigMapDemo.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ConfigMapController {
		
	 @Autowired
	 private MyConfig config;
	 
	 @Value("${welcome.message}")
	private String welcomeMessage;
	
	@Value("${greeting.message}")
	private String greetingMessage;
	 
	 @Scheduled(fixedDelay = 5000)
	 @GetMapping("/config")
	 public String configTest() {
        System.out.println("The message is: " + config.getMessage());
        return String.format(config.getMessage());
	 }

	@GetMapping("/helloTomcat")
	public String helloTom() {		
	    
		System.out.println("Hello Tomcat");
		
		return "Hello Tomcat Headers";
	}
	
	@GetMapping("/welcome")
	private String welcome() {
        
        return String.format(welcomeMessage);
	}
	
	@GetMapping("/greeting")
	private String greeting() {
       return String.format(greetingMessage);
	}
}
