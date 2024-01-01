package com.qussai.security.eCommerce.repository;

import java.util.List;

import com.qussai.security.eCommerce.model.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDao extends JpaRepository<MyOrder, Integer>{


	public List<MyOrder> findAll();
	
}
