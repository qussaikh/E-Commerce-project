package com.qussai.security.eCommerce.repository;


import com.qussai.security.eCommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
	
	public Address findByaddressId(Integer addressId);
	
	public List<Address> findByCity(String city);
	
	

}
