package com.practice.springCloudFunction;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringCloudFunctionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionExampleApplication.class, args);
	}
	
	@Bean
	public Function<String, String> function(){
		return input -> input;
	}
	
	@Bean
	public Consumer<String> consume(){
		return input -> {
			System.out.println("input : " +input);
		};
	}
	
	@Bean
	public Supplier<String> supply(){
		return () -> "HelloThisIsSupplier";
	}

}
