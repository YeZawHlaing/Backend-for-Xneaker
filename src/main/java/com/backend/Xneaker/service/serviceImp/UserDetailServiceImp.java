package com.backend.Xneaker.service.serviceImp;

import com.backend.Xneaker.model.User;
import com.backend.Xneaker.model.UserDetail;
import com.backend.Xneaker.repository.UserRepository;
import com.backend.Xneaker.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user=  userRepository.findByUsername(username);

        return new UserDetail(user);
    }
}
