package com.qussai.security.eCommerce.dto.cart;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddToCartDto {

    private Integer id;
    @Column(nullable = false)
    private  Integer productId;
    @Column(nullable = false)
    private  Integer quantity;
}
