package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<User, Integer> {
    User findOneByUsername(String username);
}
