package com.example.utilidades.commns.init;

import com.example.utilidades.commns.user.User;
import com.example.utilidades.commns.user.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = userRepository.findByUserName("arnaldo");
        if (user == null){
            user = new User();
            user.setName("Arnaldo");
            user.setUserName("arnaldo");
            user.setPassword("1234");
            user.getRoles().add("ADMIN");
            userRepository.save(user);
        }

        User user1 = userRepository.findByUserName("user");
        if (user1 == null){
            user = new User();
            user.setName("User");
            user.setUserName("user");
            user.setPassword("1234");
            user.getRoles().add("USER");
            userRepository.save(user);
        }
    }
}
