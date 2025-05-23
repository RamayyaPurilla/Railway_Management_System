package com.example.irctc.Controller;
import com.example.irctc.DTO.Response.TrainResponse;
import com.example.irctc.Service.TrainService;
import com.example.irctc.Service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trains")
public class UserTrainController {

    @Autowired
    TrainServiceImpl trainService;

    @GetMapping("/availability")
    public ResponseEntity<List<TrainResponse>> getTrainAvailability(
            @RequestParam String source,
            @RequestParam String destination) {
        List<TrainResponse> trains = trainService.getAvailableTrains(source, destination);
        return ResponseEntity.ok(trains);
    }
}

