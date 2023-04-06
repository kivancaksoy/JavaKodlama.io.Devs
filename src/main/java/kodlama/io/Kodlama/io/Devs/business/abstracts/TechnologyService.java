package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedTechnologyResponse;

public interface TechnologyService {
	CreatedTechnologyResponse add(CreateTechnologyRequest createTechnologyRequest);
	UpdatedTechnologyResponse update(UpdateTechnologyRequest updateTechnologyRequest);
	void delete(int id);
	
	List<GetAllTechnologiesResponse> getAll();
	GetByIdTechnologyResponse getById(int id);
}
