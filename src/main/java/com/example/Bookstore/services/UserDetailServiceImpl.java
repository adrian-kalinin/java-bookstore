package com.example.Bookstore.services;

import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.createAuthorityList(user.getRole());
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorityList);
    }

}
