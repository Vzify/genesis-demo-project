package com.genesis.demo.mappers;

import com.genesis.demo.dto.ContactDTO;
import com.genesis.demo.dto.ContactTypeDTO;
import com.genesis.demo.model.Contact;
import com.genesis.demo.model.ContactType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContactMapper {

    private final AddressMapper addressMapper;

    public ContactDTO fromDomain(Contact contact){
        return ContactDTO.builder()
                .id(contact.getId())
                .firstname(contact.getFirstname())
                .lastname(contact.getLastname())
                .address(addressMapper.fromDomain(contact.getAddress()))
                .vat(contact.getVat())
                .contactTypeDTO(ContactTypeDTO.valueOf(contact.getContactType().name()))
                .build();
    }

    public Contact toDomain(ContactDTO contactDTO){
        return Contact.builder()
                .firstname(contactDTO.getFirstname())
                .lastname(contactDTO.getLastname())
                .vat(contactDTO.getVat())
                .address(addressMapper.toDomain(contactDTO.getAddress()))
                .contactType(ContactType.valueOf(contactDTO.getContactTypeDTO().name()))
                .build();

    }
}
