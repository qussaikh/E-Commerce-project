package com.qussai.security.eCommerce.model;

import java.time.LocalDateTime;
import java.util.List;

import com.qussai.security.webSecurity.user.User;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MyOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime localdtetime;
	String orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	User user;

	@OneToMany(cascade = CascadeType.ALL)
	List<Products>productlist;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
}
