package com.example.smallcompany.service;

import com.example.smallcompany.repositary.AddressRepository;
import com.example.smallcompany.repositary.CompanyRepository;
import com.example.smallcompany.entity.Address;
import com.example.smallcompany.entity.Company;
import com.example.smallcompany.payload.ApiResponse;
import com.example.smallcompany.payload.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;

    public ApiResponse addCompany(CompanyDto companyDto) {
        Company company = new Company();
        if (!companyRepository.existsByCorpName(companyDto.getCorpName())) {
            return new ApiResponse("this company name already exists",false);
        }
        company.setCorpName(companyDto.getCorpName());
        company.setDirectorName(companyDto.getDirectorName());
        Address address = new Address();
        address.setStreet(companyDto.getStreet());
        address.setHomeNumber(companyDto.getHomeNumber());
        if (!companyRepository.existsByAddress(address)) {
            return new ApiResponse("you are wrong. This company address already " +
                    "exists and it belongs to another company",false);
        }
        Address savedAddress = addressRepository.save(address);
        company.setAddress(savedAddress);
        companyRepository.save(company);
        return new ApiResponse("company saved",true);




    }

    public List<Company> getCompanies(int page, int size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Company> companyPage=companyRepository.findAll(pageable);
        return companyPage.getContent();
    }
}
