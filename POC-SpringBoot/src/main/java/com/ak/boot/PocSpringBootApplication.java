package com.ak.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.ak.boot.repository.AuditAwareImpl;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class PocSpringBootApplication {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditAwareImpl();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PocSpringBootApplication.class, args);
	}

}
