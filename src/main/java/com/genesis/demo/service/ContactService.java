package com.genesis.demo.service;

import com.genesis.demo.exception.VatNumberAlreadyExistsException;
import com.genesis.demo.model.Contact;

public interface ContactService {
    Contact findById(Long id);
    Contact save(Contact contact) throws VatNumberAlreadyExistsException;
    Contact edit(Contact toDomain, Long id) throws VatNumberAlreadyExistsException;
    void deleteContact(Long id);
}
