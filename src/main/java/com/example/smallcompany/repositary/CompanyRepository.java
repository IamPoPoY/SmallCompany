package com.example.smallcompany.repositary;

import com.example.smallcompany.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
