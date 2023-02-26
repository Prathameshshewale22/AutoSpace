package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ServiceCenter;

public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

}
