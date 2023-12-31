package com.example.smallcompany.repositary;
import com.example.smallcompany.entity.Address;
import com.example.smallcompany.projection.CastomAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "address",excerptProjection = CastomAdress.class)
public interface AddressRepository extends JpaRepository<Address,Integer> {
    @RestResource(path = "byStreet")
    public List<Address> findAllByStreet(String street);

}
