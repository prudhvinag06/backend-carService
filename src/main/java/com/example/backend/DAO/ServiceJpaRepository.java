package com.example.backend.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceJpaRepository extends JpaRepository<Service, Long> {
    List<Service> findByLocation(String location);

}
