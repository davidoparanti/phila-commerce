package com.decagon.phila.repository;

import com.decagon.phila.model.Address;
import com.decagon.phila.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Boolean existsAddressByUserAndAddressAndCityAndState(User user, String address, String city, String state);
    Optional<List<Address>> findAllByUser(User user);

    Optional<Address> findAddressByUserAndAddressAndCityAndState(User user, String address, String city, String state);
}
