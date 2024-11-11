package com.backend.Xneaker.service.serviceImp;

import com.backend.Xneaker.model.User;
import com.backend.Xneaker.repository.UserRepository;
import com.backend.Xneaker.service.TokenService;
import com.backend.Xneaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

     private final UserRepository userRepository;
    AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(16);

    @Override
    public User CreateUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public String verifyUser(User user){

        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));

        if(authentication.isAuthenticated()){
            return tokenService.generateToken(user.getName());
        }
        return "failed";
    }
}
