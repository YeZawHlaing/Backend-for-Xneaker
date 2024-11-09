package com.backend.Xneaker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class SellerDto {

    private long s_id;

    @NotNull(message = "name is required.")
    @Size(max = 20, message = "name is too long")
    private String name;

    @NotNull(message = "Email is required.")
    @Email
    @Size(max = 191, message = "Email cannot exceed 191 characters")
    private String email;

    @NotNull(message = "Password is required.")
    @Size(min = 8, message = "Password must have at least 8 characters.")
    private String password;

    @NotNull(message = "contact number is required")
    @Pattern(regexp = "\\d{3} \\d{3} \\d{3,4}")
    private String contact_no;

    @NotNull(message = "address is require.")
    private String Address;
}
