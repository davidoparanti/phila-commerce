package com.decagon.phila.service;

import com.decagon.phila.dto.CartItemDTO;
import com.decagon.phila.model.CartItem;
import com.decagon.phila.model.User;
import com.decagon.phila.payload.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    Response addItemToCart(User user, CartItemDTO cartItemDTO);
    CartItem saveCartItem(CartItem item);
    List<CartItemDTO> getCartItems(User user);
    ResponseEntity<Response> deleteCartItemById(Long id);
}
