package org.example.aopexam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopexamApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(SimpleService service, AnotherService anotherService, UserController userController) {
        return args -> {
            // service.doSomething();
            String returnValue = service.doSomething2();
            System.out.println(returnValue);

            // System.out.println("=============================");

            // anotherService.anotherMethod();

            // System.out.println("=============================");
            // service.hello();

            userController.addUser();
        };
    }
}
