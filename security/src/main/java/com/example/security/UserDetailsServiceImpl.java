package com.example.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private Map<String, MyUserDetails> users = new HashMap<>();

    public UserDetailsServiceImpl() {
        users.put("user1", new MyUserDetails("user1", "password1", true, "ROLE_USER"));
        users.put("admin", new MyUserDetails("admin", "password2", true, "ROLE_ADMIN"));
    }

    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return users.get(username);
    }
}
