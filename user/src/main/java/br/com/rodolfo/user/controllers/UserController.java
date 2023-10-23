package br.com.rodolfo.user.controllers;

import br.com.rodolfo.user.models.User;
import br.com.rodolfo.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user){

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
}
