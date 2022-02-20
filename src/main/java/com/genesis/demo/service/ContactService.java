package com.genesis.demo.service;

import com.genesis.demo.model.Contact;

public interface ContactService {
    Contact findById(Long id);
    Contact save(Contact contact);
    Contact edit(Contact toDomain, Long id);
    void deleteContact(Long id);
}
