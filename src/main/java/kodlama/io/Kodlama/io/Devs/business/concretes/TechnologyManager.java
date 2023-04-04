package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.Technology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {

	
	private TechnologyRepository technologyRepository;
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		Optional<ProgrammingLanguage> optionalProgrammingLanguage =
				programmingLanguageRepository.findById(createTechnologyRequest.getProgrammingLanguageId());
		
		technology.setName(createTechnologyRequest.getName());
		technology.setProgrammingLanguage(optionalProgrammingLanguage.get());
		
		technologyRepository.save(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology = 
				technologyRepository.findById(
						updateTechnologyRequest.getId()).orElseThrow(() -> 
	    				new RuntimeException("Technology not found"));
		Optional<ProgrammingLanguage> optionalProgrammingLanguage =
				programmingLanguageRepository.findById(updateTechnologyRequest.getProgrammingLanguageId());
		
		technology.setName(updateTechnologyRequest.getName());
		technology.setProgrammingLanguage(optionalProgrammingLanguage.get());	
		
		technologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		Technology technology = new Technology();
		technology.setId(deleteTechnologyRequest.getId());
		
		technologyRepository.delete(technology);
		
	}

	@Override
	public List<GetAllTechnologiesResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologiesResponse> getAllTechnologiesResponses = 
				new ArrayList<GetAllTechnologiesResponse>();
		
		for (Technology technology : technologies) {
			GetAllTechnologiesResponse response = new GetAllTechnologiesResponse();
			response.setId(technology.getId());
			response.setName(technology.getName());
			response.setProgrammingLAnguageName(technology.getProgrammingLanguage().getName());
			
			getAllTechnologiesResponses.add(response);
		}
		
		return getAllTechnologiesResponses;
	}

	@Override
	public GetByIdTechnologyResponse getById(int id) {
		Optional<Technology> technologyOptional =
				technologyRepository.findById(id);
		GetByIdTechnologyResponse getByIdTechnologyResponse = new GetByIdTechnologyResponse();
		getByIdTechnologyResponse.setId(technologyOptional.get().getId());
		getByIdTechnologyResponse.setName(technologyOptional.get().getName());
		getByIdTechnologyResponse.setProgrammingLanguageName(technologyOptional.get().getProgrammingLanguage().getName());;
		
		return getByIdTechnologyResponse;
	}

}
