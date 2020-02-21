package io.javabrains.jwt.DbInit;


import com.github.javafaker.Faker;
import io.javabrains.jwt.model.User;
import io.javabrains.jwt.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;


/*

@Component
public class DbInitializer implements CommandLineRunner {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public FileWriter myWriter;

    {
        try {
            File f = new File("user_and_password.txt");
            if(f.exists())
            {
                f.delete();
            }

            myWriter = new FileWriter("./user_and_password.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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
                write(user);
                userRepository.save(user);
            }
        myWriter.close();

        System.out.println(" -- Database has been initialized");
    }

    void write(User user) throws IOException {

        myWriter.write(user.getUsername() +"\t\t" + user.getPassword() + "\n");


    }

}*/
