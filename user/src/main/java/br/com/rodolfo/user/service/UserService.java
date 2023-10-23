package br.com.rodolfo.user.service;

import br.com.rodolfo.user.models.User;
import br.com.rodolfo.user.produces.UserProduces;
import br.com.rodolfo.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserProduces userProduces;

    public UserService(UserRepository userRepository, UserProduces userProduces) {
        this.userRepository = userRepository;
        this.userProduces = userProduces;
    }

    @Transactional
    public User saveUser(User user){
        User newUser = userRepository.save(user);;
        userProduces.publishMessageEmail(newUser);
        return newUser;
    }
}
