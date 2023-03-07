package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

}
