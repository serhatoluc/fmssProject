package com.hrproject.fmssproject.repository;

import com.hrproject.fmssproject.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
