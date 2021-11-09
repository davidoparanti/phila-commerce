package com.decagon.phila.service;

import com.decagon.phila.dto.OrderRequestDTO;
import com.decagon.phila.dto.OrderResponseDTO;

public interface CheckOutService {
    OrderResponseDTO doCheckout(OrderRequestDTO orderRequestDTO, String email);
}
