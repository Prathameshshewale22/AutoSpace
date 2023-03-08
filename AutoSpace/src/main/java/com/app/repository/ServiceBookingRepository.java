package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ServiceBooking;
import com.app.pojos.ServiceStatus;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long>{
	
	List<ServiceBooking> findAllBookingsByStatus(ServiceStatus status);
	
	List<ServiceBooking> findAllBookingByCustomerId(Long id);

}
