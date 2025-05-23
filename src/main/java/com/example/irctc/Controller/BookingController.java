package com.example.irctc.Controller;
import com.example.irctc.DTO.Request.BookingRequest;
import com.example.irctc.DTO.Response.BookingResponse;
import com.example.irctc.Service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    BookingServiceImpl bookingService;

    @PostMapping("/book")
    public ResponseEntity<BookingResponse> bookSeat(
            @RequestBody BookingRequest request,
            @AuthenticationPrincipal UserDetails userDetails) {
        BookingResponse response = bookingService.bookSeat(request, userDetails.getUsername());
        return ResponseEntity.ok(response);
    }

}

