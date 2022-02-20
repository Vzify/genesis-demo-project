package com.genesis.demo.service;

import com.genesis.demo.model.Contact;
import com.genesis.demo.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepository contactRepository;

    @Override
    public Contact findById(Long id) {
        return this.contactRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Contact save(Contact contact) {
        return this.contactRepository.save(contact);
    }

    @Override
    public Contact edit(Contact contact, Long id) {
        Contact mappedEntity = this.findById(id);
        mappedEntity.setAddress(contact.getAddress());
        mappedEntity.setContactType(contact.getContactType());
        mappedEntity.setFirstname(contact.getFirstname());
        mappedEntity.setLastname(contact.getLastname());
        return this.save(mappedEntity);
    }

    @Override
    public void deleteContact(Long id) {
        Contact contact = this.findById(id);
        contact.getEnterprises().forEach(enterprise -> enterprise.deleteContact(contact));
        this.contactRepository.deleteById(id);
    }
}
