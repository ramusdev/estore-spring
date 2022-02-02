package com.rb.estore.service;

import com.rb.estore.database.InterfaceUserDao;
import com.rb.estore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements InterfaceUserService {

    @Autowired
    InterfaceUserDao interfaceUserDao;

    @Override
    public User getUserById(int userId) {
        Optional<User> userOptional = interfaceUserDao.getUserById(userId);

        if (userOptional.isEmpty()) {
            return null;
        }

        return userOptional.get();
    }
}
