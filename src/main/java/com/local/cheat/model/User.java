package com.local.cheat.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.EnumSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.local.cheat.constants.UserRole;

import lombok.Data;

@Data
public class User implements UserDetails {
	
	private Integer userId;
	
    private String username;

    private String password;
    
    private Integer role;
    
    private Timestamp createAt;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO 自動生成されたメソッド・スタブ
        return true;
    }
    
    public String getRoleName() {
    	switch (role) {
		case 1:
			return "USER";
		case 2:
			return "ADMIN";
		case 3:
			return "API";
		default:
			return "???";
		}
    }

}
