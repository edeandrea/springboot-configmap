package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class GreetingController {
	private final DemoConfigProperties configProperties;

	public GreetingController(DemoConfigProperties configProperties) {
		this.configProperties = configProperties;
	}

	@GetMapping(path = "/{user}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String greet(@PathVariable String user) {
		// Changing the ConfigMap changes the properties as well automatically
		return String.format("%s %s! Welcome to the Configuring Spring Boot on Kubernetes!", this.configProperties.getWelcomeMessage(), user);
	}
}
