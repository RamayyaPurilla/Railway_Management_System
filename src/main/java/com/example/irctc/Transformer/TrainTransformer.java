package com.example.irctc.Transformer;

import com.example.irctc.DTO.Request.TrainRequest;
import com.example.irctc.DTO.Response.TrainResponse;
import com.example.irctc.Entity.Train;
import org.springframework.stereotype.Component;

@Component
public class TrainTransformer {

    public Train TrainRequestToTrain(TrainRequest request)
    {
        Train train = Train.builder()
                .name(request.getTrainName())
                .source(request.getSource())
                .destination(request.getDestination())
                .totalSeats(request.getTotalSeats())
                .availableSeats(request.getTotalSeats())
                .trainId(request.getTrainId())
                .build();
        return train;
    }

    public TrainResponse TrainToTrainResponse(Train train)
    {
        TrainResponse trainResponse=TrainResponse.builder()
                .trainId(train.getTrainId())
                .name(train.getName())
                .source(train.getSource())
                .destination(train.getDestination())
                .totalSeats(train.getTotalSeats())
                .availableSeats(train.getAvailableSeats())
                .bookingList(train.getBookingList())
                .build();
        return trainResponse;
    }
}
