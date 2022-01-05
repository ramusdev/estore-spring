package com.rb.estore.database;

import com.rb.estore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.Optional;

@Repository
public class UserDAO implements InterfaceUserDAO {

    @Autowired
    Connection connection;

    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        return Optional.empty();
    }
}
