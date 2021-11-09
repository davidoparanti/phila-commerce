package com.decagon.phila.security.service;

import com.decagon.phila.model.User;
import com.decagon.phila.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        User user = userService.findUserByEmail(email);

        return UserDetailsImpl.build(user);
    }
}
