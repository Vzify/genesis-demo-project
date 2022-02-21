package com.genesis.demo.rest;

import com.genesis.demo.dto.EnterpriseDTO;
import com.genesis.demo.exception.VatNumberAlreadyExistsException;
import com.genesis.demo.mappers.EnterpriseMapper;
import com.genesis.demo.model.Enterprise;
import com.genesis.demo.service.EnterpriseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(EnterpriseController.CONTEXT_ROOT)
public class EnterpriseController {
    public static final String CONTEXT_ROOT = "/enterprise";
    private final EnterpriseService enterpriseService;
    private final EnterpriseMapper enterpriseMapper;

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> getById(@PathVariable("id") Long id){
        Enterprise enterprise = this.enterpriseService.findById(id);
        return new ResponseEntity<>(this.enterpriseMapper.fromDomain(enterprise), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnterpriseDTO> create(@RequestBody @Valid EnterpriseDTO enterpriseDTO) throws VatNumberAlreadyExistsException {
        return new ResponseEntity<>(this.enterpriseMapper.fromDomain(this.enterpriseService
                .create(enterpriseMapper.toDomain(enterpriseDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> edit(@RequestBody EnterpriseDTO enterpriseDTO, @PathVariable("id") Long id){
        return new ResponseEntity<>(this.enterpriseMapper.fromDomain(this.enterpriseService
                .updateEnterprise(enterpriseMapper.toDomain(enterpriseDTO), id)), HttpStatus.OK);
    }

    @PostMapping("/{id}/contact/{contactId}")
    public void addContactToEnterprise(@PathVariable("id") Long id, @PathVariable("contactId") Long contactId ){
        this.enterpriseMapper.fromDomain(this.enterpriseService.addContactToEnterprise(id,contactId));
    }
}
