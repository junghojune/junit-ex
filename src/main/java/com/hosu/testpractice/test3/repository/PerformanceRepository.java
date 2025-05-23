package com.hosu.testpractice.test3.repository;

import com.hosu.testpractice.test3.domain.entity.ticketing.Performance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface PerformanceRepository extends JpaRepository<Performance, UUID> {
    List<Performance> findByIsReserve(String isReserve);
    Performance findByName(String name);
}
