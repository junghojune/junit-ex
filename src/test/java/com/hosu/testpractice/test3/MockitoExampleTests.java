package com.hosu.testpractice.test3;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import com.hosu.testpractice.test3.domain.dto.Ticket;
import com.hosu.testpractice.test3.repository.ReservationRepository;
import com.hosu.testpractice.test3.service.PerformanceService;
import com.hosu.testpractice.test3.service.TicketingService;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MockitoExampleTests {
    @Mock
    PerformanceService performanceService;
    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    private TicketingService ticketingService;


    @Test
    void ticketingTest() {
        Ticket t = Ticket.builder()
                .performanceId(UUID.fromString("adc45fd5-dab9-11ee-9743-0242ac130002"))
                .performanceName("레베카")
                .reservationName("유진호")
                .reservationPhoneNumber("010-1234-1234")
                .reservationStatus("reserve")
                .round(1)
                .line('A')
                .seat(1)
                .appliedPolicies(Arrays.asList(new String[]{"telecome"}))
                .build();

        Mockito.when(performanceService.isEnableReserve(any()))
                .then(invocationOnMock -> {
                    System.out.println("Execute Mocking Code");
                    return "disable";
                });

        assertThrows(NoSuchElementException.class, () -> ticketingService.ticketing(t));
//        ticketingService.ticketing(t);

        Mockito.verify(performanceService, Mockito.times(1)).isEnableReserve(any());
        Mockito.verify(reservationRepository, Mockito.times(1)).save(any());


    }
}
