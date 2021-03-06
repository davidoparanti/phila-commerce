package com.decagon.phila.service;

import com.decagon.phila.model.ShippingAddress;
import com.decagon.phila.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ShippingAddressService {
    List<ShippingAddress> getAllUserShippingAddresses(User user);

    ShippingAddress getUserDefaultShippingAddress(User user);

    ShippingAddress saveShippingAddress(ShippingAddress shippingAddressRequest, User user);

    ShippingAddress editShippingAddress(Long addressId, ShippingAddress shippingAddressRequest, User user);

    ResponseEntity<?> deleteShippingAddress(Long addressId, User user);

}
