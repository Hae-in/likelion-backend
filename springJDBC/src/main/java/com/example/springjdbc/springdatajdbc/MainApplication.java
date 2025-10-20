package com.example.springjdbc.springdatajdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return args -> {
            // repository.save(new User("John", "Doe@gmail.com"));

            System.out.println("\n=== findById ===");
            User user = repository.findById(1L).get();
            System.out.println(user);

            System.out.println("\n=== findAll ===");
            repository.findAll().forEach(System.out::println);

            System.out.println("\n=== findByName ===");
            User user1 = repository.findByName("kim");
            System.out.println(user1);

            System.out.println("\n=== findByEmail ===");
            User user2 = repository.findByEmail("Doe@gmail.com").get();
            System.out.println(user2);

            System.out.println("\n=== abcUser ===");
            repository.abcUser("test");
        };
    }
}
