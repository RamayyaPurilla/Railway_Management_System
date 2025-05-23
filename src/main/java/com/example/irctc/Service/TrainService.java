package com.example.irctc.Service;

import com.example.irctc.DTO.Request.TrainRequest;
import com.example.irctc.DTO.Response.TrainResponse;

import java.util.List;

public interface TrainService {
    public TrainResponse addTrain(TrainRequest request);
    public List<TrainResponse> getAvailableTrains(String source, String destination);
}
