package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.DeliveryBoy;
@Repository
public interface DeliveryBoyRepository extends JpaRepository<DeliveryBoy, Long>{
	
	List<DeliveryBoy> findAllDeliveryBoysByScenterId( Long id);

}
