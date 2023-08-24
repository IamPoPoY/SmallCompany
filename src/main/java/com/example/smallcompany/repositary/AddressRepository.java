package com.example.smallcompany.repositary;

import com.example.smallcompany.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
