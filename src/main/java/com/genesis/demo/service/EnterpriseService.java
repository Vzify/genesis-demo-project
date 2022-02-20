package com.genesis.demo.service;

import com.genesis.demo.model.Enterprise;

public interface EnterpriseService {
    Enterprise create(Enterprise enterprise);
    Enterprise addContactToEnterprise(Long Id, Long contactId);
    Enterprise updateEnterprise(Enterprise enterprise);
    Enterprise findById(Long id);
}
