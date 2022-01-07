package com.rb.estore.service;

import com.rb.estore.database.InterfaceUserDao;
import com.rb.estore.model.User;
import com.rb.estore.model.view.RegisterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

@Service
public class AuthenticationService implements InterfaceAuthenticationService {
    @Autowired
    InterfaceUserDao interfaceUserDao;

    @Override
    public void register(RegisterUser registerUser) {
        registerUser.setPassword(DigestUtils.md5Hex(registerUser.getPassword()));
        interfaceUserDao.addUser(registerUser);
    }

    @Override
    public void login(String login, String password) {
        Optional<User> user = this.interfaceUserDao.getUserByLogin(login);

        System.out.println(user.get().getName());
    }
}
