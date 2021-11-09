package com.decagon.phila.dto;

import com.decagon.phila.model.OrderedItem;
import com.decagon.phila.model.ShippingAddress;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderResponseDTO {

    private  Long orderId;

    private String quantity;

    private String deliveryMethod;

    private Date dateOrdered;

    private Double cardDiscount;

    private Date dateDelivered;

    private Double deliveryFee;

    private String paymentType;

    private String status;

    private Double costOfProducts; //alias subtotal

    private Boolean isGift;

    private Double totalCost;

    private ShippingAddress shippingAddress;

    private List<OrderedItem> orderedItems;

    private UserDTO orderedBy;

}
