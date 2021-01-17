package com.znzn.mythymeleaf.service;

import com.znzn.mythymeleaf.model.Role;
import com.znzn.mythymeleaf.model.User;
import com.znzn.mythymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1L);

        user.getRoles().add(role);
        userRepository.save(user);
        return userRepository.save(user);
    }
}
