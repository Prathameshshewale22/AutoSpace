package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findAllByCustomerId(Long id);

}
