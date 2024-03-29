package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Services;
@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

}
