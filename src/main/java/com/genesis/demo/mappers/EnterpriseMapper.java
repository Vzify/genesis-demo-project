package com.genesis.demo.mappers;

import com.genesis.demo.dto.EnterpriseDTO;
import com.genesis.demo.model.Enterprise;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EnterpriseMapper {
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;

    public EnterpriseDTO fromDomain(Enterprise enterprise) {
        return EnterpriseDTO.builder()
                .id(enterprise.getId())
                .VAT(enterprise.getVAT())
                .address(addressMapper.fromDomain(enterprise.getAddress()))
                .contacts(enterprise.getContacts() != null ?
                        enterprise.getContacts()
                                        .stream()
                                        .map(contactMapper::fromDomain)
                                        .collect(Collectors.toSet()): Collections.EMPTY_SET)
                .build();
    }

    public Enterprise toDomain(EnterpriseDTO enterpriseDTO){
        return  Enterprise.builder()
                .id(enterpriseDTO.getId())
                .VAT(enterpriseDTO.getVAT())
                .address(addressMapper.toDomain(enterpriseDTO.getAddress()))
                .build();
    }


}
