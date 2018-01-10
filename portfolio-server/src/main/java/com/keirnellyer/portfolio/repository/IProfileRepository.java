package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.entity.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends CrudRepository<Profile, Integer> {
}
