package com.cpr.codingparkrangers.repository;

import com.cpr.codingparkrangers.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
