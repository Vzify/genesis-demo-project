package com.genesis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class ContactDTO {
    private Long id;
    @NotNull(message = "firstname is mandatory")
    private String firstname;
    @NotNull(message = "lastname is mandatory")
    private String lastname;
    @NotNull(message = "contact type is mandatory")
    private ContactTypeDTO contactTypeDTO;
    @NotNull(message = "address is mandatory")
    @Valid
    private AddressDTO address;
    private String vat;
}
