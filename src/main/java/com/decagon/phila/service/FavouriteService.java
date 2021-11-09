package com.decagon.phila.service;

import com.decagon.phila.security.service.UserDetailsImpl;
import org.springframework.http.ResponseEntity;

public interface FavouriteService {
    String customerAddProductToFavorite(UserDetailsImpl userImpl, Long productId);
    ResponseEntity<?> getFavouriteProducts(UserDetailsImpl userImpl);
    ResponseEntity<?> getFavouriteProductsById(Long productId);
}
