package com.dancing.stars.controller;

import com.dancing.stars.controller.mapper.UserMapper;
import com.dancing.stars.entity.User;
import com.dancing.stars.entity.dto.UserDTO;
import com.dancing.stars.exception.UnauthorizedException;
import com.dancing.stars.service.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
//        List<User> users = service.getAllUsers();
//        List<UserDTO> userDTOs = users.stream()
//                .map(mapper::entityToDTO)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(userDTOs);
        return null;
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email) {
        User user = service.getUserByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserDTO userDTO = mapper.entityToDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) throws BadRequestException {
        User result = service.createUser(email, password);
        return ResponseEntity.ok(mapper.entityToDTO(result));
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password) throws BadRequestException, UnauthorizedException {
        User user = service.login(email, password);

        return ResponseEntity.ok(mapper.entityToDTO(user));

//        request.getSession().setAttribute(SessionManager.LOGGED, true);
//        request.getSession().setAttribute(SessionManager.LOGGED_FROM, request.getRemoteAddr());
//        request.getSession().setAttribute(SessionManager.USER_ID, user.getId());
    }

//    @PutMapping("/change/password")
//    public ResponseEntity<UserDTO> changePassword(@RequestParam String email, HttpServletRequest request) {
//        SessionManager.validateLogin(request);
//        // emailService.sendEmail(userDTO.getEmail(), "password", "changed password");
//        int userId = (Integer) request.getSession().getAttribute(SessionManager.USER_ID);
//        User user = service.changePassword(userDTO, userId);
//        UserResponseDTO dto = mapper.map(user, UserResponseDTO.class);
//
//        return ResponseEntity.ok(dto);
//    }
//
//    @PutMapping("/forgot/password")
//    public ResponseEntity<UserResponseDTO> forgotPassword(@RequestBody UserEditDTO userDTO, HttpServletRequest request) {
//        SessionManager.validateLogin(request);
//        int userId = (Integer) request.getSession().getAttribute(SessionManager.USER_ID);
//        User user = service.forgotPassword(userDTO, userId);
//        UserResponseDTO dto = mapper.map(user, UserResponseDTO.class);
//
//        return ResponseEntity.ok(dto);
//    }

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email) throws BadRequestException {
        service.deleteUser(email);
        return ResponseEntity.ok("user was deleted succesfully");
    }

}
