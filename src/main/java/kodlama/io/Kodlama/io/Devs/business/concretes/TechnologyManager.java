package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

	
	private TechnologyRepository technologyRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public CreatedTechnologyResponse add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = 
				modelMapperService.forRequest().map(createTechnologyRequest, Technology.class);
		Technology createdTechnology = technologyRepository.save(technology);
		
		CreatedTechnologyResponse createdTechnologyResponse = 
				modelMapperService.forResponse().map(createdTechnology, CreatedTechnologyResponse.class);
		
		return createdTechnologyResponse;
		
	}

	@Override
	public UpdatedTechnologyResponse update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = 
				modelMapperService.forRequest().map(updateTechnologyRequest, Technology.class);
		Technology updatedTechnology = technologyRepository.save(technology);
		
		UpdatedTechnologyResponse updatedTechnologyResponse = 
				modelMapperService.forResponse().map(updatedTechnology, UpdatedTechnologyResponse.class);
		
		return updatedTechnologyResponse;
	}

	@Override
	public void delete(int id) {
		technologyRepository.deleteById(id);
		
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		
		List<GetAllTechnologiesResponse> getAllTechnologiesResponses =
				technologies.stream().map(technology -> 
				modelMapperService.forResponse()
				.map(technology, GetAllTechnologiesResponse.class))
				.toList();
		
		return getAllTechnologiesResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Technology technology =
				technologyRepository.findById(id).orElseThrow(() -> 
					new RuntimeException("Technology not found"));
		GetByIdTechnologyResponse getByIdTechnologyResponse =
				modelMapperService.forResponse().map(technology, GetByIdTechnologyResponse.class);
		
		return getByIdTechnologyResponse;
	}

}
