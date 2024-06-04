package com.dancing.stars.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.dancing.stars.entity.User;
import com.dancing.stars.exception.BadRequestException;
import com.dancing.stars.exception.NotFoundException;
import com.dancing.stars.exception.UnauthorizedException;
import com.dancing.stars.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserByEmail(String email) {
        if (email == null) {
            throw new NullPointerException("No input data!");
        } else {
            Optional<User> result = repository.findByEmail(email);

            if (result.isEmpty()) {
                throw new NotFoundException("User not found");
            } else {
                return result.get();
            }
        }
    }

    public User createUser(String email, String password) throws BadRequestException {
        validatePassword(password);
        validateEmail(email);

        User user = new User();
        user.setEmail(email);
        user.setPassword(hashPassword(password));

        repository.save(user);

        return user;
    }


    public void deleteUser(String email) throws BadRequestException {
        validateEmail(email);
        repository.delete(getUserByEmail(email));
    }

    public User login(String email, String password) throws BadRequestException, UnauthorizedException {
        validateEmail(email);
        validatePassword(password);

        Optional<User> user = repository.findByEmail(email);

        if (user.isEmpty()) {
            throw new NotFoundException("User not found");
        }


        if (!checkPassword(password, user.get().getPassword())) {
            throw new UnauthorizedException("Wrong credentials! Access denied!");
        }

        return user.get();
    }

    private static void validateEmail(String email) throws BadRequestException {
        if (email.isBlank()) {
            throw new BadRequestException("Email is a mandatory field!");
        }
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new BadRequestException("You must enter valid email address!");
        }
    }

    private static void validatePassword(String password) throws BadRequestException {
        if (password.isBlank()) {
            throw new BadRequestException("Password is a mandatory field!");
        }
        if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*])(?=\\S+$).{8,20}$")) {
            throw new BadRequestException("Password should be: at least 8 symbols long. " +
                    "Contain at least one digit. " +
                    "Contain at least one upper case character. " +
                    "No spaces are allowed.");
        }
    }

    private static String hashPassword(String plainTextPassword) {
        return BCrypt.withDefaults().hashToString(12, plainTextPassword.toCharArray());
    }

    private static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        BCrypt.Result result = BCrypt.verifyer().verify(plainTextPassword.toCharArray(), hashedPassword);
        return result.verified;
    }

}
