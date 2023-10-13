package Coding.rentACar.business.abstracts;

import java.util.List;

import Coding.rentACar.business.requests.CreateBrandRequest;
import Coding.rentACar.business.requests.UpdateBrandRequest;
import Coding.rentACar.business.responses.GetAllBrandsResponse;
import Coding.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
