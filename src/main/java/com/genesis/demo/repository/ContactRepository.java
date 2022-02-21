package com.genesis.demo.repository;

import com.genesis.demo.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
     Optional<Contact> findContactByVat(String vatNumber);
}
