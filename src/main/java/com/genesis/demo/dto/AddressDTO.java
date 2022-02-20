package com.genesis.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@Validated
public class AddressDTO {
    private Long id;
    @NotNull(message = "street is mandatory")
    private String street;
    @NotNull(message = "house number is mandatory")
    private String number;
    @NotNull(message = "postal Code is mandatory")
    private String postalCode;
    @NotNull(message = "city is mandatory")
    private String city;
    @NotNull(message = "country is mandatory")
    private String country;
}
