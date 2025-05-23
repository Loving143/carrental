package com.carrental.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.security.model.CustomUser;

public interface CustomerRepository  extends JpaRepository<CustomUser, Integer>{

	Optional<CustomUser> findByEmail(String email);

}
