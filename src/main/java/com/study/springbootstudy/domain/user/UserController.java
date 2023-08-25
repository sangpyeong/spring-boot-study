package com.study.springbootstudy.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        return authenticated ? "Login successful" : "Invalid username or password";
    }

    @GetMapping("/exists/username")
    public boolean existsByUsername(@RequestParam String username) {
        return userService.existsByUsername(username);
    }

    @GetMapping("/exists/email")
    public boolean existsByEmail(@RequestParam String email) {
        return userService.existsByEmail(email);
    }

    // TODO: 로그아웃, 아이디/비밀번호 찾기 기능 추가
}
