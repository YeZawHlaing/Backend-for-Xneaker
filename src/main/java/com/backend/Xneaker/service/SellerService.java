package com.backend.Xneaker.service;

import com.backend.Xneaker.dto.SellerDto;

public interface SellerService {

    SellerDto CreateSeller(SellerDto sellerDto);
    SellerDto getSellerByID(Long s_id);

    SellerDto getSellerByName(String name);
    SellerDto getSellerByEmail(String email);
}
