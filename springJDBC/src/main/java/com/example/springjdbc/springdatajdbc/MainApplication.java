package com.example.springjdbc.springdatajdbc;

import com.example.springjdbc.jdbc01.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return args -> {
            // repository.save(new User("John", "Doe@gmail.com"));
            User user = repository.findById(1L).get();
            System.out.println(user);
        };
    }
}
