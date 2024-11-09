package com.backend.Xneaker.service.serviceImp;

import com.backend.Xneaker.dto.SellerDto;
import com.backend.Xneaker.model.Seller;
import com.backend.Xneaker.repository.SellerRepository;
import com.backend.Xneaker.service.SellerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceImp implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapper modelMapper;

    public SellerServiceImp(SellerRepository sellerRepository, ModelMapper modelMapper) {
        this.sellerRepository = sellerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public SellerDto CreateSeller(SellerDto sellerDto) {
        Seller seller = modelMapper.map(sellerDto, Seller.class);
        Seller savedSeller = sellerRepository.save(seller);
        return modelMapper.map(savedSeller, SellerDto.class);
    }

    @Override
    public SellerDto getSellerByID(Long s_id) {
        Seller seller = sellerRepository.findById(s_id).orElse(null);
        if (seller == null) {
            return null;
        }
        return modelMapper.map(seller, SellerDto.class);
    }

    @Override
    public SellerDto getSellerByName(String name) {
        Optional<Seller> seller = sellerRepository.findByName(name);
        if (seller == null) {
            return null;
        }
        return modelMapper.map(seller, SellerDto.class);
    }

    @Override
    public SellerDto getSellerByEmail(String email) {
        Optional<Seller> seller = sellerRepository.findByEmail(email);
        if (seller == null) {
            return null;
        }
        return modelMapper.map(seller, SellerDto.class);
    }
}
