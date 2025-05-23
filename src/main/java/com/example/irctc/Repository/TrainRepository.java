package com.example.irctc.Repository;

import com.example.irctc.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainRepository extends JpaRepository<Train,Long> {
    List<Train> findBySourceAndDestination(String source, String destination);

}
