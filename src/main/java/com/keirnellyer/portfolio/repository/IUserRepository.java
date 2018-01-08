package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends CrudRepository<User, Integer> {
    User findOneByUsername(String username);
}
