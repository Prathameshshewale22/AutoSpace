package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.DeliveryBoy;

public interface DeliveryBoyRepository extends JpaRepository<DeliveryBoy, Long>{
	
	List<DeliveryBoy> findAllDeliveryBoysByCenterId(Long id);

}
