package com.example.smallcompany.repositary;

import com.example.smallcompany.entity.Address;
import com.example.smallcompany.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
    Boolean existsByCorpName(String corpName);
    Boolean existsByAddress(Address address);

}
