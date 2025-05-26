package com.carrental.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carrental.security.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

	Object findByRoleCode(String roleCode);

}
