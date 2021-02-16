package com.example.exelondemo;

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
		// To see the property value reload, change the value in the property source (i.e. ConfigMap)
		// Then issue a POST to http://<app-url>/actuator/refresh
		// The re-try this request
		return String.format("%s %s! Welcome to the Configuring Spring Boot on Kubernetes!", this.configProperties.getWelcomeMessage(), user);
	}
}
