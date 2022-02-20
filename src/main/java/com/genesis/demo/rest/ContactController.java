package com.genesis.demo.rest;

import com.genesis.demo.dto.ContactDTO;
import com.genesis.demo.exception.ContactVatNumberException;
import com.genesis.demo.mappers.ContactMapper;
import com.genesis.demo.model.Contact;
import com.genesis.demo.service.ContactService;
import com.genesis.demo.util.ContactValidatorUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(ContactController.CONTEXT_ROOT)
public class ContactController {
    public static final String CONTEXT_ROOT = "/contact";

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO contactDTO) throws ContactVatNumberException {
        if(!ContactValidatorUtil.isValid(contactDTO)){
            throw new ContactVatNumberException("Freelance or Employee vat number is incorrect");
        }
        return new  ResponseEntity<>(this.contactMapper.fromDomain(
                this.contactService.save(contactMapper.toDomain(contactDTO))),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDTO> getContact(@PathVariable("id") Long id){
        Contact contact = this.contactService.findById(id);
        return new ResponseEntity<>(this.contactMapper.fromDomain(contact),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> editContact(@RequestBody ContactDTO contactDTO, @PathVariable("id") Long id){
        if(!ContactValidatorUtil.isValid(contactDTO)){
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.contactMapper
                .fromDomain(this.contactService.edit(contactMapper.toDomain(contactDTO),id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable("id") Long id){
        this.contactService.deleteContact(id);
    }
}
