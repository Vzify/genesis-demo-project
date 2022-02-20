package com.genesis.demo.mappers;

import com.genesis.demo.dto.AddressDTO;
import com.genesis.demo.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO fromDomain(Address address){
        return  AddressDTO.builder()
                .id(address.getId())
                .street(address.getStreet())
                .number(address.getNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }


    public Address toDomain(AddressDTO addressDTO){
        return Address.builder()
                .id(addressDTO.getId())
                .street(addressDTO.getStreet())
                .number(addressDTO.getNumber())
                .postalCode(addressDTO.getPostalCode())
                .city(addressDTO.getCity())
                .country(addressDTO.getCountry())
                .build();
    }
}
