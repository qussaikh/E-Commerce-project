package com.qussai.security.eCommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressId;
	@NotNull(message = "please fill sreeet number")
	private String streetNo;
	@NotNull(message = "please fill Building name")
	private String buildingName;
	@NotNull(message = "please fill City name")
	private String city;
	@NotNull(message = "please fill state name")
	private String state;
	@NotNull(message = "please fill country name")
	private String country;
	//@Pattern(regexp = "([1-9]{1}[0-9]{5}|[1-9]{1}[0-9]{3}\\\\s[0-9]{3})",message = "please input a valid pincode")
	private String pincode;
	

}
