//package com.study.springbootstudy.domain.user;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.study.springbootstudy.security.JWTUtil;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//public class UserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private JWTUtil jwtUtil;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void testRegister() throws Exception {
//        User user = new User("username", "password", "email");
//        when(userService.register(any(User.class))).thenReturn(user);
//
//        mockMvc.perform(post("/users/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isOk())
//                .andExpect(content().json(objectMapper.writeValueAsString(user)));
//    }
//
//    // Add more test methods for login, existsByUsername, and existsByEmail
//}
//
