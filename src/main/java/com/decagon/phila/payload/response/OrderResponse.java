package com.decagon.phila.payload.response;

import com.decagon.phila.dto.CartItemDTO;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long orderId;
    private Long userId;
    private String quantity;
    private String status;
    private List<CartItemDTO> orderedProducts;
    private String dateOrdered;
    private String dateDelivered;
    private UserDTO orderedBy;
}
