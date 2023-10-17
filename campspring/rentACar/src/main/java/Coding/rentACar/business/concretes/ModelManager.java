package Coding.rentACar.business.concretes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Coding.rentACar.business.abstracts.ModelService;
import Coding.rentACar.business.requests.CreateModelRequest;
import Coding.rentACar.business.responses.GetAllModelsResponse;
import Coding.rentACar.core.utilities.mappers.ModelMapperService;
import Coding.rentACar.dataAccess.abstracts.ModelRepository;
import Coding.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Model::getId))
                .collect(Collectors.toList());

        List<GetAllModelsResponse> modelsResponses = models.stream()
                .map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,
                Model.class);

        this.modelRepository.save(model);
    }

}
