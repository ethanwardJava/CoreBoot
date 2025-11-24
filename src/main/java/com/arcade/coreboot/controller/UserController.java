package com.arcade.coreboot.controller;

import com.arcade.coreboot.entity.User;
import com.arcade.coreboot.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // ====== ADD NEW USER ========
    @PostMapping("/new")
    public User addUser(@RequestBody @Valid User user) {
        userService.add(user);
        return user;
    }

    // ====== FIND BY USERNAME ========
    @GetMapping("")
    public User findByUsername(@RequestParam @Valid String username) {
        return userService.findByUsername(username);
    }

    // ====== GET ALL ========
    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid User user) {
        var u = userService.findByUsername(user.getUsername());
        if (!Objects.isNull(u)) {
            return "Success";
        }
        return "failed";
    }

}
