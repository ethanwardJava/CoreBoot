package com.arcade.coreboot.service;

import com.arcade.coreboot.CustomUserDetails;
import com.arcade.coreboot.entity.User;
import com.arcade.coreboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@RequiredArgsConstructor
@Component
@Log4j2
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (Objects.isNull(user)) {
            System.out.println("User not found");
            log.warn("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new CustomUserDetails(user);
    }
}
