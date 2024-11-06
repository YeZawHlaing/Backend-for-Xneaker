package com.backend.Xneaker.service.serviceImp;

import com.backend.Xneaker.model.User;
import com.backend.Xneaker.repository.UserRepository;
import com.backend.Xneaker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

     private final UserRepository userRepository;
    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
