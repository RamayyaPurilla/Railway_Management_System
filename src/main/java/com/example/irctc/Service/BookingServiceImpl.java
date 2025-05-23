package com.example.irctc.Service;
import com.example.irctc.DTO.Request.BookingRequest;
import com.example.irctc.DTO.Response.BookingResponse;
import com.example.irctc.Entity.Booking;
import com.example.irctc.Entity.Train;
import com.example.irctc.Entity.User;
import com.example.irctc.Repository.BookingRepository;
import com.example.irctc.Repository.TrainRepository;
import com.example.irctc.Repository.UserRepository;
import com.example.irctc.Transformer.BookingTransformer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{


    @Autowired
    TrainRepository trainRepository;

    @Autowired
    BookingTransformer bookingTransformer;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Override
    @Transactional
    public BookingResponse bookSeat(BookingRequest request, String username)
    {
        Train train=trainRepository.findByIdForUpdate(request.getTrainId()).orElseThrow(()->
                new RuntimeException("Train not found"));
        if(train.getAvailableSeats()<=0)
        {
            throw  new RuntimeException("No seats available");
        }
        train.setAvailableSeats(train.getAvailableSeats()-1);

        User user=userRepository.findByUsername(username).orElseThrow(()->
                new RuntimeException("User not found"));
        Booking booking=bookingTransformer.BookingRequestToBooking();
        Booking savedBooking=bookingRepository.save(booking);
        user.getBookings().add(savedBooking);
        train.getBookingList().add(savedBooking);
        trainRepository.save(train);
        userRepository.save(user);
        BookingResponse bookingResponse=bookingTransformer.BookingToBookingResponse(savedBooking,user,train);
        return bookingResponse;
    }

}
