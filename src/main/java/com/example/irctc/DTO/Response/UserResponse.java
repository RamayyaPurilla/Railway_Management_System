package com.example.irctc.DTO.Response;

import com.example.irctc.Entity.Booking;
import com.example.irctc.Enum.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String username;
    private Role role;
    private List<Booking> bookingList;
}
