package org.kevzgtech.magiccreatureswebapp.ui.controller;

import org.kevzgtech.magiccreatureswebapp.model.UserEntity;
import org.kevzgtech.magiccreatureswebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        System.out.println("Register: " + user);
        userService.createUser(user);
        return null;
    }
}
