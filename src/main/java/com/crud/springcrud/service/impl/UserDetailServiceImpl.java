package com.crud.springcrud.service.impl;

import com.crud.springcrud.entity.Account;
import com.crud.springcrud.entity.Role;
import com.crud.springcrud.repository.AccountRepository;
import com.crud.springcrud.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User " + username + " not found!");
        }
        if (CollectionUtils.isEmpty(account.getRoles())) {
            throw new RuntimeException("User has no roles!");
        }
        Collection<GrantedAuthority> authorities = account.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return new User(account.getUsername(), account.getPassword(), account.isEnable(), !account.isExpired(),
                !account.isCredentialsExpired(), !account.isLocked(), authorities);
    }
}
