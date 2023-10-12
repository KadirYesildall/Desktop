package Coding.rentACar.business.concretes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Coding.rentACar.business.abstracts.BrandService;
import Coding.rentACar.business.requests.CreateBrandRequest;
import Coding.rentACar.business.responses.GetAllBrandsResponse;
import Coding.rentACar.dataAccess.abstracts.BrandRepository;
import Coding.rentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;

    public BrandManager(BrandRepository brandRepository) {
        super();
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll().stream()
                .sorted(Comparator.comparing(Brand::getId))
                .collect(Collectors.toList());

        List<GetAllBrandsResponse> brandsResponses = new ArrayList<GetAllBrandsResponse>();

        for (Brand brand : brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }
        return brandsResponses;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }

}