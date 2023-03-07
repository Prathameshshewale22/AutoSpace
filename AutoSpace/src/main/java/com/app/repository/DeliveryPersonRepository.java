package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.DeliveryBoy;
@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryBoy, Long>{

}
