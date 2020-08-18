package edu.akdeniz.eticaret.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.akdeniz.eticaret.mapper.UserMapper;
import edu.akdeniz.eticaret.model.UserInfModel;

@Service("userService")
public class UserServiceImplements implements UserService{

	@Autowired
	UserMapper userMapper;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfModel user = userMapper.getUserbyUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Bu kullanýcý adý için kayýt bulunamadý:"+ username);
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getRolAdi()));
		return new org.springframework.security.core.userdetails.User(user.getKullaniciAdi(), user.getSifre(), grantedAuthorities);
	}

}
