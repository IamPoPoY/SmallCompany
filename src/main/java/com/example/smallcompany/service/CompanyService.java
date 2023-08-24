package com.example.smallcompany.service;

import com.example.smallcompany.repositary.AddressRepository;
import com.example.smallcompany.repositary.CompanyRepository;
import com.example.smallcompany.entity.Address;
import com.example.smallcompany.entity.Company;
import com.example.smallcompany.payload.ApiResponce;
import com.example.smallcompany.payload.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    public ApiResponce addCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        Address savedAddress = addressRepository.save(address);
        company.setAddress(savedAddress);
        companyRepository.save(company);
        return new ApiResponce("company saved",true);




    }
}
