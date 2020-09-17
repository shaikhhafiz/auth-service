package com.hafiz.erp.auth.config;

import com.hafiz.erp.auth.entity.User;
import com.hafiz.erp.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class SpringSecUserService implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByName(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        //TODO get these authorities from client
        authorities.add(new SimpleGrantedAuthority("admin"));
        authorities.add(new SimpleGrantedAuthority("user"));
        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getName(), user.getPassword(), authorities);
        return userDetails;
    }
}
