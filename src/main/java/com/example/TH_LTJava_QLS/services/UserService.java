package com.example.TH_LTJava_QLS.services;

import com.example.TH_LTJava_QLS.Model.User;
import com.example.TH_LTJava_QLS.Repository.IRoleRepository;
import com.example.TH_LTJava_QLS.Repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("User");
        if(roleId !=0 && userId !=0){
            userRepository.addRoleToUser(userId, roleId);
        }
    }
}
