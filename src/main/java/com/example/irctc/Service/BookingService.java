package com.example.irctc.Service;

import com.example.irctc.DTO.Request.BookingRequest;
import com.example.irctc.DTO.Response.BookingResponse;

public interface BookingService {
    public BookingResponse bookSeat(BookingRequest request, String username);
}
