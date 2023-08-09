package org.technosoft.businesscard.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.technosoft.businesscard.model.Role;
import org.technosoft.businesscard.repository.SecurityUserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final SecurityUserRepository securityUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var securityUser = securityUserRepository.findSecurityUsersByUsername(username)
                .orElseThrow(NoSuchElementException::new);
        return new User(
                passwordEncoder.encode(securityUser.getUsername()),
                securityUser.getPassword(),
                true,
                true,
                true,
                true,
                mapRolesToAuthorities(securityUser.getRoles()));
    }

    public List<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
