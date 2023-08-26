package com.example.smallcompany.repositary;
import com.example.smallcompany.entity.Address;
import com.example.smallcompany.projection.CastomAdress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "address",excerptProjection = CastomAdress.class)
public interface AddressRepository extends JpaRepository<Address,Integer> {


}
