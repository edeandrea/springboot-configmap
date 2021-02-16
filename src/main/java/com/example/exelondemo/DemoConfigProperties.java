package com.example.exelondemo;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties("poc")
@Validated
public class DemoConfigProperties {
	@NotEmpty
	private String welcomeMessage = "Hello!";

	public String getWelcomeMessage() {
		return this.welcomeMessage;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
}
