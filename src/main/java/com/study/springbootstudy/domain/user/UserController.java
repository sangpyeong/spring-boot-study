package com.study.springbootstudy.domain.user;

import com.study.springbootstudy.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        boolean authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if(authenticated) {
            String token = jwtUtil.generateToken(user.getUsername());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
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
