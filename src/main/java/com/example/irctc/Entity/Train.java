package com.example.irctc.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "trains")
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainId;
    private String name;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "train_id")
    private List<Booking> bookingList=new ArrayList<>();
}

