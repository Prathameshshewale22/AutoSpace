package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.DeliveryBoy;

public interface DeliveryPersonRepository extends JpaRepository<DeliveryBoy, Long>{

}
