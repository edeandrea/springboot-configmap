package com.example.exelondemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
	@Value("${myprop:Hello!}")
	private String myProp;

	@GetMapping(path = "/{user}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet(@PathVariable String user) {
		return String.format("%s %s! Welcome to the Configuring Spring Boot on Kubernetes!", this.myProp, user);
	}
}