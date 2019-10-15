package com.app.repository;

import com.app.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByEmail(String email);
}
