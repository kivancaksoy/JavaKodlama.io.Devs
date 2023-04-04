package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;

public interface TechnologyService {
	void add(CreateTechnologyRequest createTechnologyRequest);
	void update(UpdateTechnologyRequest updateTechnologyRequest);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);
	
	List<GetAllTechnologiesResponse> getAll();
	GetByIdTechnologyResponse getById(int id);
}
