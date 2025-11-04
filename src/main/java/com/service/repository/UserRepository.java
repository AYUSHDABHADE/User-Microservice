package com.service.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{
   public User findById(Integer id);
   
}
