package com.example.irctc.DTO.Response;

import com.example.irctc.Entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainResponse {
    private String name;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    private String trainId;
    private List<Booking> bookingList;
}
