package com.example.irctc.Transformer;

import com.example.irctc.DTO.Request.BookingRequest;
import com.example.irctc.DTO.Response.BookingResponse;
import com.example.irctc.Entity.Booking;
import com.example.irctc.Entity.Train;
import com.example.irctc.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class BookingTransformer {

    public BookingResponse BookingToBookingResponse(Booking booking, User user, Train train)
    {
        BookingResponse bookingResponse=BookingResponse.builder()
                .bookingId(booking.getId())
                .userId(user.getId())
                .trainName(train.getName())
                .bookingTime(booking.getBookingTime())
                .status("CONFIRMED")
                .destination(train.getDestination())
                .source(train.getSource())
                .trainId(train.getTrainId())
                .build();
        return bookingResponse;
    }

    public Booking BookingRequestToBooking()
    {
        Booking booking=Booking.builder().bookingStatus("Completed").
                price(400.00)
                .seatNumber("S4-10")
                .paymentStatus("Done")
                .transactionId("transactionId")
                .build();
        return booking;
    }
}
