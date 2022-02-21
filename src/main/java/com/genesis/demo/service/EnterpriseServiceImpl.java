package com.genesis.demo.service;

import com.genesis.demo.exception.VatNumberAlreadyExistsException;
import com.genesis.demo.model.Enterprise;
import com.genesis.demo.repository.EnterpriseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@AllArgsConstructor
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final ContactService contactService;

    @Override
    public Enterprise create(Enterprise enterprise) throws VatNumberAlreadyExistsException {
        Enterprise enterprise1 = this.findByVat(enterprise.getVat());
        if(enterprise1 != null){
            throw new VatNumberAlreadyExistsException("VAT number is already assigned to a company");
        }
        return this.enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise addContactToEnterprise(Long enterpriseId, Long contactId) {
        Enterprise enterprise = this.enterpriseRepository.findById(enterpriseId).orElseThrow(EntityNotFoundException::new);
        enterprise.addContact(this.contactService.findById(contactId));
        return this.enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise updateEnterprise(Enterprise incoming, Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        enterprise.setAddress(incoming.getAddress());
        enterprise.setVat(incoming.getVat());
        return this.enterpriseRepository.save(enterprise);
    }

    @Override
    public Enterprise findById(Long id) {
        return this.enterpriseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    private Enterprise findByVat(String vat){
        return this.enterpriseRepository.findEnterpriseByVat(vat).orElse(null);
    }
}
