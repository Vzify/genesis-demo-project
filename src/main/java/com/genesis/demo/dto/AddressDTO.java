package com.genesis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
@Validated
public class AddressDTO {
    private Long id;
    @NotBlank(message = "street is mandatory")
    private String street;
    @NotBlank(message = "house number is mandatory")
    private String number;
    @NotBlank(message = "postal Code is mandatory")
    private String postalCode;
    @NotBlank(message = "city is mandatory")
    private String city;
    @NotBlank(message = "country is mandatory")
    private String country;
}
