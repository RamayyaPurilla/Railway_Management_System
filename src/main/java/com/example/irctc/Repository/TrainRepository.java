package com.example.irctc.Repository;

import com.example.irctc.Entity.Train;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train,Long> {
    List<Train> findBySourceAndDestination(String source, String destination);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT t FROM Train t WHERE t.id = :trainId")
    Optional<Train> findByIdForUpdate(Long trainId);

}
