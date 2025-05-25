package com.carrental.security.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrental.security.dto.AddRoleRequest;
import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.model.CustomUser;
import com.carrental.security.model.Role;
import com.carrental.security.repository.CustomerRepository;
import com.carrental.security.repository.RoleRepository;
import com.carrental.security.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	private final CustomerRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public CustomerServiceImpl(CustomerRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
	
	@Override
	public void registerCustomer(RegisterCustomerRequest request) {
		
		CustomUser user = new CustomUser(request);
		ArrayList<Role>roles = new ArrayList();
		for(AddRoleRequest roleReq : request.getRoles()) {
			Role role = new Role(roleReq);
			roles.add(role);
		}
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		userRepository.save(user);
		
	}

}
