package com.example.TH_LTJava_QLS.services;

import com.example.TH_LTJava_QLS.Model.User;
import com.example.TH_LTJava_QLS.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;
    public void save(User user){
        userRepository.save(user);
    }
}
