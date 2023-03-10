package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.ServiceCenter;
@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {
	
	 ServiceCenter findByCenterManagerId(Long id);

}
