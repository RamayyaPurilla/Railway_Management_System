package com.example.irctc.DTO.Response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private Long userId;
    private String trainName;
    private LocalDateTime bookingTime;
    private String trainId;
    private String source;
    private String destination;
    private String status;
}

