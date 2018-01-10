package com.keirnellyer.portfolio.repository;

import com.keirnellyer.portfolio.entity.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteRepository extends CrudRepository<Site, Integer> {
}
