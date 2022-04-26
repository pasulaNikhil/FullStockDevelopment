package com.example.Authentication.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.Authentication.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public Optional<User> findByName(String name);
}