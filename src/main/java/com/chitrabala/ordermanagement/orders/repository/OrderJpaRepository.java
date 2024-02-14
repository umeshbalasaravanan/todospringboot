package com.chitrabala.ordermanagement.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitrabala.ordermanagement.entity.Orderinfo;

@Repository
public interface OrderJpaRepository extends JpaRepository<Orderinfo, Long>{

}
