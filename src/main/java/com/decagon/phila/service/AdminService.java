package com.decagon.phila.service;

import com.decagon.phila.dto.ProductDTO;
import com.decagon.phila.model.Product;
import com.decagon.phila.model.ProductPage;
import com.decagon.phila.payload.response.Response;
import com.decagon.phila.payload.response.auth.ResetPassword;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    ResponseEntity<Response> adminForgotPassword(HttpServletRequest req, String email);
    ResponseEntity<Response> adminResetPassword(ResetPassword resetPassword);
    ResponseEntity<Page<ProductDTO>> getAllProducts(ProductPage adminProductPage);
    ResponseEntity<Product> getSingleProduct(Long productId);
}
