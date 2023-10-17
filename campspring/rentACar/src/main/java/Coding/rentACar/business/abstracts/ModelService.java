package Coding.rentACar.business.abstracts;

import java.util.List;

import Coding.rentACar.business.requests.CreateModelRequest;
import Coding.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
