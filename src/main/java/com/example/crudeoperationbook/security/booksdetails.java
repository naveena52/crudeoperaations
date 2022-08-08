package com.example.crudeoperationbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class booksdetails implements UserDetailsService {
    @Autowired
    private com.example.crudeoperationbook.repository.booksrepo booksrepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return booksrepo.findByEmail(username).orElseThrow();
    }

}