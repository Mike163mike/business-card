package org.technosoft.businesscard.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.technosoft.businesscard.model.Role;
import org.technosoft.businesscard.repository.SecurityUserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SecurityUserService implements UserDetailsService {

    private final SecurityUserRepository securityUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var securityUser = securityUserRepository.findSecurityUsersByUsername(username);
        var role = new Role();
        role.setName("USER");
        return securityUser.map(user -> new User(
                        user.getUsername(),
                        user.getPassword(),
                        true,
                        true,
                        true,
                        true,
                        mapRolesToAuthorities(user.getRoles())))
                .orElseGet(() -> new User(
                        "Stranger",
                        "$2a$12$WIF7iut1rjofbtyNnx44GeawadAYyQ3JfN84ng1dszuqLgNfU4LFm",
                        mapRolesToAuthorities(List.of())));
    }

    public List<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
