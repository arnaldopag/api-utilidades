package com.example.utilidades.commns.configurations;

import com.example.utilidades.commns.user.User;
import com.example.utilidades.commns.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityDataBaseService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUserName(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> authorities = userEntity.getAuthorities().stream()
                .map( role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                authorities);
    }

}

