package com.arcade.coreboot.service.user;

import com.arcade.coreboot.entity.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {
    void add(@Valid User user);

    User findByUsername(@Valid String username);

    List<User> findAll();
}
