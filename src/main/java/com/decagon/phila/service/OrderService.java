package com.decagon.phila.service;

import com.decagon.phila.dto.OrderResponseDTO;
import com.decagon.phila.model.Order;
import com.decagon.phila.model.User;
import com.decagon.phila.payload.request.UpdateOrderRequest;
import com.decagon.phila.payload.response.PagedOrderByStatusResponse;
import java.util.List;

public interface OrderService {
    OrderResponseDTO getOrder(Long orderId);
    PagedOrderByStatusResponse<OrderResponseDTO> userGetOrderByStatus(String status, User user, int page, int size);
    PagedOrderByStatusResponse<OrderResponseDTO> adminGetOrderByStatus(String status,User user, int page, int size);
    Order saveOrder(Order order);
    PagedOrderByStatusResponse<OrderResponseDTO> adminGetOrderByUser(Long userId, Integer page, Integer size);
    PagedOrderByStatusResponse<OrderResponseDTO> userGetOrderByUser(Integer page, Integer size);
    void updateOrderStatus(Long orderId, UpdateOrderRequest orderRequest);
    void userConfirmOrderStatus(Long orderId);
    List<OrderResponseDTO> getAllOrdersAdmin();
}
