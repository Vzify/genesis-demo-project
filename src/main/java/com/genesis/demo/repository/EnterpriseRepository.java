package com.genesis.demo.repository;

import com.genesis.demo.model.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends CrudRepository<Enterprise, Long> {

    Optional<Enterprise>findEnterpriseByVat(String vatNumber);
}
