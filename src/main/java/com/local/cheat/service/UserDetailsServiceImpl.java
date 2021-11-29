package com.local.cheat.service;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.local.cheat.constants.UserRole;
import com.local.cheat.form.ChangePasswordForm;
import com.local.cheat.form.UserForm;
import com.local.cheat.mapper.UserMapper;
import com.local.cheat.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	var user = userMapper.findByUsername(username);
    	
    	Set<UserRole> roles;
    	
    	switch (user.getRole()) {
		case 1:
			roles = EnumSet.of(UserRole.ROLE_USER);
			break;
		case 2:
			roles = EnumSet.of(UserRole.ROLE_USER, UserRole.ROLE_ADMIN);
			break;
		case 3:
			roles = EnumSet.of(UserRole.ROLE_API);
			break;
		default:
			throw new UsernameNotFoundException("not found");
		}
    	
    	Collection<? extends GrantedAuthority> authorities = roles.stream()
    			.map(UserRole::name).map(SimpleGrantedAuthority::new)
    			.collect(Collectors.toList());
    	
    	user.setAuthorities(authorities);
    	
        return user;
    }
    
    public void registUser(UserForm form) {
    	var user = new User(); 
    	user.setPassword(passwordEncoder.encode(form.getPassword()));
    	user.setUsername(form.getUsername());
    	userMapper.insert(user);
    }
    
    public boolean userExist(String username) {
    	return null!=userMapper.findByUsername(username);
    }

	public void updatePassword(ChangePasswordForm form,User user) {
		user.setPassword(passwordEncoder.encode(form.getNewPassword()));
		userMapper.updatePassword(user);
	}

	public boolean passwordMatch(String password, String username) {
		var user = userMapper.findByUsername(username);
		return passwordEncoder.matches(password, user.getPassword());
	}
    
    
}

