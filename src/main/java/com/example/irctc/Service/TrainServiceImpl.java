package com.example.irctc.Service;

import com.example.irctc.DTO.Request.TrainRequest;
import com.example.irctc.DTO.Response.TrainResponse;
import com.example.irctc.Entity.Train;
import com.example.irctc.Repository.TrainRepository;
import com.example.irctc.Transformer.TrainTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService{

    @Autowired
    TrainTransformer trainTransformer;

    @Autowired
    TrainRepository trainRepository;
    @Override
    public TrainResponse addTrain(TrainRequest request) {
        Train train=trainTransformer.TrainRequestToTrain(request);
        Train savedTrain=trainRepository.save(train);
        TrainResponse trainResponse=trainTransformer.TrainToTrainResponse(savedTrain);
        return trainResponse;
    }

    @Override
    public List<TrainResponse> getAvailableTrains(String source, String destination) {
        List<Train> trainList=trainRepository.findBySourceAndDestination(source,destination);
        List<TrainResponse> trainResponseList=new ArrayList<>();
        for(Train train:trainList)
        {
            trainResponseList.add(trainTransformer.TrainToTrainResponse(train));
        }
        return trainResponseList;
    }
}
