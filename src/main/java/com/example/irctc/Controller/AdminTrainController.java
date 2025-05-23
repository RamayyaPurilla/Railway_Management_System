package com.example.irctc.Controller;
import com.example.irctc.DTO.Request.TrainRequest;
import com.example.irctc.DTO.Response.TrainResponse;
import com.example.irctc.Service.TrainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/train")
public class AdminTrainController {

    @Autowired
    TrainServiceImpl trainService;

    @PostMapping("/add")
    public ResponseEntity<TrainResponse> addTrain(@RequestBody TrainRequest request) {
        TrainResponse trainResponse=trainService.addTrain(request);
        return ResponseEntity.ok(trainResponse);
    }
}

