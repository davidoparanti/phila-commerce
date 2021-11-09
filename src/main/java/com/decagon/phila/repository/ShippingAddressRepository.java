package com.decagon.phila.repository;

import com.decagon.phila.model.ShippingAddress;
import com.decagon.phila.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
    Optional<List<ShippingAddress>> findAllByUser(User user);
    Boolean existsAddressByUserAndAddressAndCityAndState(User user, String address, String city, String state);
    Optional<ShippingAddress> findAddressByUserAndAddressAndCityAndState(User user, String address, String city, String state);
}
