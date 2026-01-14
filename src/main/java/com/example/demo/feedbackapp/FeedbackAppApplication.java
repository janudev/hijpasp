package com.feedbackapp;

import com.feedbackapp.entity.User;
import com.feedbackapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FeedbackAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeedbackAppApplication.class, args);
    }
    
    @Bean
    public CommandLineRunner initData(UserRepository userRepository, 
                                      PasswordEncoder passwordEncoder) {
        return args -> {
            // Crear usuario admin por defecto
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
                System.out.println("Admin user created: username=admin, password=admin123");
            }
        };
    }
}