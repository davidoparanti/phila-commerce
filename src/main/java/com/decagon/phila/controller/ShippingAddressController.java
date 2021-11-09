package com.decagon.phila.controller;


import com.decagon.phila.model.ShippingAddress;
import com.decagon.phila.model.User;
import com.decagon.phila.service.ShippingAddressService;
import com.decagon.phila.service.UserService;
import com.decagon.phila.utils.JWTUtil;
import com.decagon.phila.utils.MethodUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shipping_address")
public class ShippingAddressController {


    private final ShippingAddressService shippingAddressService;
    private final UserService userService;
    private final JWTUtil jwtUtil;

    @GetMapping("/")
    public List<ShippingAddress> getAllUserAddresses(HttpServletRequest request){
        String jwt = MethodUtils.parseJwt(request);
        String email = jwtUtil.extractUserName(jwt);
        User user = userService.findUserByEmail(email);
        return shippingAddressService.getAllUserShippingAddresses(user);
    }

    @GetMapping("/default")
    public ShippingAddress getUserDefaultShippingAddress(HttpServletRequest request) {
        String jwt = MethodUtils.parseJwt(request);
        String email = jwtUtil.extractUserName(jwt);
        User user = userService.findUserByEmail(email);
        return shippingAddressService.getUserDefaultShippingAddress(user);
    }

    @PostMapping("/add")
    public ResponseEntity<ShippingAddress> addNewShippingAddress(@Valid @RequestBody ShippingAddress shippingAddressRequest,
                                                 HttpServletRequest request){
        String jwt = MethodUtils.parseJwt(request);
        String email = jwtUtil.extractUserName(jwt);
        User user = userService.findUserByEmail(email);
        ShippingAddress shippingAddress = shippingAddressService.saveShippingAddress(shippingAddressRequest, user);
        return new ResponseEntity<>(shippingAddress, HttpStatus.OK);
    }

    @PutMapping("/edit/{addressId}")
    public ResponseEntity<ShippingAddress> editShippingAddress(@Valid @RequestBody ShippingAddress shippingAddressRequest, @PathVariable Long addressId,
                                                               HttpServletRequest request){
        String jwt = MethodUtils.parseJwt(request);
        String email = jwtUtil.extractUserName(jwt);
        User user = userService.findUserByEmail(email);
        ShippingAddress shippingAddress = shippingAddressService.editShippingAddress(addressId, shippingAddressRequest, user);
        return new ResponseEntity<>(shippingAddress, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity<?> deleteShippingAddress(@PathVariable Long addressId, HttpServletRequest request) {
        String jwt = MethodUtils.parseJwt(request);
        String email = jwtUtil.extractUserName(jwt);
        User user = userService.findUserByEmail(email);
        return shippingAddressService.deleteShippingAddress(addressId, user);
    }


}
