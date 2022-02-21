package com.genesis.demo.service;

import com.genesis.demo.exception.VatNumberAlreadyExistsException;
import com.genesis.demo.model.Enterprise;

public interface EnterpriseService {
    Enterprise create(Enterprise enterprise) throws VatNumberAlreadyExistsException;
    Enterprise addContactToEnterprise(Long enterpriseId, Long contactId);
    Enterprise updateEnterprise(Enterprise enterprise, Long enterpriseId);
    Enterprise findById(Long id);
}
