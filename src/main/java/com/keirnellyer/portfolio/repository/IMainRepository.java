package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.database.User;

import java.util.List;
import java.util.Optional;

public interface IMainRepository {
    List<User> getUsers();
    Optional<User> getUserByUsername(String username);
    int addUser(User user);
    void updateUser(User user);
}
