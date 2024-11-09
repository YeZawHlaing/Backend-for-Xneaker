package com.backend.Xneaker.controller;

import com.backend.Xneaker.dto.SellerDto;
import com.backend.Xneaker.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/backend/")
@CrossOrigin
@RequiredArgsConstructor
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/create")
    public ResponseEntity<SellerDto> createSeller(@Valid @RequestBody SellerDto sellerDto) {
        SellerDto createdSeller = sellerService.CreateSeller(sellerDto);
        return ResponseEntity.ok(createdSeller);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerDto> getSellerByID(@PathVariable Long id) {
        SellerDto seller = sellerService.getSellerByID(id);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller);
    }


    @GetMapping("/name/{name}")
    public ResponseEntity<SellerDto> getSellerByName(@PathVariable String name) {
        SellerDto seller = sellerService.getSellerByName(name);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<SellerDto> getSellerByEmail(@PathVariable String email) {
        SellerDto seller = sellerService.getSellerByEmail(email);
        if (seller == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(seller);
    }


}
