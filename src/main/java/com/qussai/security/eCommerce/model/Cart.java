package com.qussai.security.eCommerce.model;


import com.qussai.security.webSecurity.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@OneToOne
	@JoinColumn(name = "product_id")
	private Products cartItem;


	@ManyToOne
	private User customerlist;

//	private int quantity;

//	@CreatedBy
//	@Column(
//			nullable = false,
//			updatable = false
//	)
//	private Integer createdBy;


	//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "ADDRESS_ID", referencedColumnName = "addressId")

//	private Double cartTotal;
	



//	public Customer getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(Customer customer) {
//		this.customer = customer;
//	}

	

	
	

	
}
