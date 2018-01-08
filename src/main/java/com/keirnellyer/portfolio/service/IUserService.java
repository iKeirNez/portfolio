package com.keirnellyer.portfolio.service;

import com.keirnellyer.portfolio.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers();
    User getUser(int id);
    User getUserByUsername(String username);
}
