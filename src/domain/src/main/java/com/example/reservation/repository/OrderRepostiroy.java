package com.example.reservation.repository;

import com.example.reservation.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepostiroy extends JpaRepository<Order, Long> {

}
