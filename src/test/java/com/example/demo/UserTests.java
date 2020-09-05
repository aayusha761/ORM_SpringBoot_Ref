package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserTests {

//    @Autowired
//    private UserRepo userRepo;
//
//    public void addUser() {
//        User user = new User();
//        user.setName("aayush");
//        user.setEmail("aayush@lti.com");
//        user.setPassword("aayush@123");
//
//    }
}
