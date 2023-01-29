package com.example.demo.DAO;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.UserDB;

public interface UserDAO extends CrudRepository<UserDB,Integer> {

}
