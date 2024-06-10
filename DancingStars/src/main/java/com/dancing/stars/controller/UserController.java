package com.dancing.stars.controller;

import com.dancing.stars.config.SessionManager;
import com.dancing.stars.controller.mapper.UserMapper;
import com.dancing.stars.entity.User;
import com.dancing.stars.entity.dto.UserDTO;
import com.dancing.stars.exception.UnauthorizedException;
import com.dancing.stars.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;


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
    public ResponseEntity<UserDTO> login(@RequestParam(name = "email") String email, @RequestParam(name = "password") String password, HttpServletRequest request) throws UnauthorizedException {
        User user = service.login(email, password);

        request.getSession().setAttribute(SessionManager.LOGGED, Boolean.TRUE);
        request.getSession().setAttribute(SessionManager.LOGGED_FROM, request.getRemoteAddr());
        request.getSession().setAttribute(SessionManager.USER_ID, user.getEmail());

        return ResponseEntity.ok(mapper.entityToDTO(user));

    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest session) throws ServletException {
        session.logout();
        return ResponseEntity.ok("Logout successful");
    }


    @PutMapping("/favorite_team/add")
    public ResponseEntity<UserDTO> addFavoriteTeam(@RequestParam String email, @RequestParam String sms, HttpServletRequest request) throws UnauthorizedException {
        SessionManager.validateLogin(request);
        return ResponseEntity.ok(mapper.entityToDTO(service.addFavoriteTeam(email,sms)));
    }

    @PutMapping("/favorite_team/remove")
    public ResponseEntity<UserDTO> removeFavoriteTeam(@RequestParam String email, HttpServletRequest request) throws UnauthorizedException {
        SessionManager.validateLogin(request);
        return ResponseEntity.ok(mapper.entityToDTO(service.removeFavoriteTeam(email)));
    }


    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email, HttpServletRequest request) throws BadRequestException, UnauthorizedException {
        SessionManager.validateLogin(request);
        service.deleteUser(email);
        return ResponseEntity.ok("user was deleted successfully");
    }

}
