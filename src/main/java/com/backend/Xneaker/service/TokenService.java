package com.backend.Xneaker.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;

public interface TokenService {

    public String generateToken(String username);

}
