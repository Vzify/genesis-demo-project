package com.genesis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class EnterpriseDTO {
    private Long id;
    @NotBlank(message = "VAT is mandatory")
    private String VAT;
    private AddressDTO address;
    private Set<ContactDTO> contacts;
}