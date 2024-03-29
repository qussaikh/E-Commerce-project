package com.qussai.security.eCommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItem {

    private Long productId;
    private String productName;
    private double price;
    private String description;
    private int quantity;
    private Long createdBy;
    private String category;
}
