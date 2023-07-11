package com.retailer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailer.entity.Retailer;

@Repository
public interface RetailerRepository extends JpaRepository<Retailer, Long>{

}
