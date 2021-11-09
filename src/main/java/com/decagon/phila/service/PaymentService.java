package com.decagon.phila.service;

import com.decagon.phila.payload.response.Response;
import org.springframework.http.ResponseEntity;


public interface PaymentService {
    String getPaymentAuthorizationUrl(Long orderId) throws Exception;
    ResponseEntity<Response> confirmPayment(Long orderId) throws Exception;
}
