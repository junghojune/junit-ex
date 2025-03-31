package com.hosu.testpractice.test3.repository;

import com.hosu.testpractice.test3.domain.entity.ticketing.PerformanceDiscountPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerformanceDiscountPolicyRepository extends JpaRepository<PerformanceDiscountPolicy, UUID> {
    PerformanceDiscountPolicy findByPerformanceIdAndName(UUID performanceId, String policyName);
}
