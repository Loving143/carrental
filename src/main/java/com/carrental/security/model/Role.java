package com.carrental.security.model;

import com.carrental.security.dto.AddRoleRequest;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String roleName;
	private String roleCode;
	
	public Role(AddRoleRequest roleReq) {
		this.roleCode = roleReq.getRoleCode();
		this.roleName = roleReq.getRoleName();
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
