package com.example.demo.mapper;

import com.example.demo.Entity.User;

import java.util.List;


public interface UserMapper {

    void addUser(User user);

    List<User> getAllUsers();
}
