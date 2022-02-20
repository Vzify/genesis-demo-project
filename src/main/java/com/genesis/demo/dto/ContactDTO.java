package com.genesis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@Validated
public class ContactDTO {
    private Long id;
    @NotBlank(message = "firstname is mandatory")
    private String firstname;
    @NotNull(message = "lastname is mandatory")
    private String lastname;
    @NotNull(message = "contact type is mandatory")
    private ContactTypeDTO contactTypeDTO;
    @NotBlank(message = "address is mandatory")
    private AddressDTO address;
    private String vat;
}