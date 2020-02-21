package io.javabrains.jwt.DbInit;


import com.github.javafaker.Faker;
import io.javabrains.jwt.model.User;
import io.javabrains.jwt.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;



@Component
public class DbInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    public DbInitializer(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.userRepository.deleteAll();
        Faker usFaker = new Faker(new Locale("en-GB"));
            userRepository.deleteAll();
            for (int i = 0 ; i < 100; i++)
            {
                User user = new User();

                user.setEmail(usFaker.internet().emailAddress());
                user.setUsername(usFaker.name().fullName());
                user.setPassword(usFaker.internet().password(8,25));

                user.toString();
                userRepository.save(user);
            }

        System.out.println(" -- Database has been initialized");
    }
}