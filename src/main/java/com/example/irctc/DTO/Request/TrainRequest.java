package com.example.irctc.DTO.Request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class TrainRequest {
    private String trainName;
    private String source;
    private String destination;
    private int totalSeats;
    private String trainId;
}

