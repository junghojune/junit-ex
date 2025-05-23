package com.hosu.testpractice.test3.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class Ticket {
    // 공연 및 전시 정보 + 예약자 정보
    private UUID performanceId;
    private String performanceName;
    private String reservationName;
    private String reservationPhoneNumber;
    private String reservationStatus; // 예약; 취소;
    private int price;
    private int point;
    private long amount;
    private int round;
    private int gate;
    private char line;
    private int seat;
    private List<String> appliedPolicies;


}
