package com.carrental.security.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrental.exception.BadRequestException;
import com.carrental.security.dto.AddRoleRequest;
import com.carrental.security.dto.RegisterCustomerRequest;
import com.carrental.security.dto.SwitchRoleRequest;
import com.carrental.security.model.CustomGrantedAuthority;
import com.carrental.security.model.CustomUser;
import com.carrental.security.model.JwtUtil;
import com.carrental.security.model.Role;
import com.carrental.security.repository.CustomerRepository;
import com.carrental.security.repository.RoleRepository;
import com.carrental.security.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private JwtUtil jwtUtil;
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
		validateUser(request);
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

	private void validateUser(RegisterCustomerRequest request) {
		if(userRepository.existsByEmail(request.getEmail())){
			throw new BadRequestException("Email id already exists!");
		}
	}

	@Override
	public String switchRole(SwitchRoleRequest request, Authentication auth) {
		String name = auth.getName();
		CustomUser user = userRepository.findByEmail(auth.getName()).orElseThrow(()-> new BadRequestException("User does not exists!"));
		if(user.getRoles().stream().map(r->r.getRoleName()).collect(Collectors.toList()).contains(request.getRoleName())) {
			CustomGrantedAuthority authority = new CustomGrantedAuthority(request.getRoleName());
			List<CustomGrantedAuthority>authorities = new ArrayList<>();
			authorities.add(authority);
			String token = jwtUtil.generateToken(name,authorities);
			return token;
		}else {
			throw new BadRequestException("You do not have authorized role");
		}
	}

}
