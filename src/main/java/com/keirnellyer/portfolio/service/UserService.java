package com.keirnellyer.portfolio.service;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.keirnellyer.portfolio.entity.User;
import com.keirnellyer.portfolio.repository.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService implements IUserService {
    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    @Override
    public User getUser(int id) {
        Preconditions.checkArgument(id >= 0, "id must be positive");

        return userRepository.findOne(id);
    }

    @Override
    public User getUserByUsername(String username) {
        Preconditions.checkNotNull(username);

        return userRepository.findOneByUsername(username);
    }
}
