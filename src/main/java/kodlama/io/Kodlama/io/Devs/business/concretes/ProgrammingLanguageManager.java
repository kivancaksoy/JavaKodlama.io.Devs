package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;


	@Override
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageRequest.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
		
	}

	@Override
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setId(deleteProgrammingLanguageRequest.getId());
		
		programmingLanguageRepository.delete(programmingLanguage);
	}

	@Override
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
	    ProgrammingLanguage programmingLanguage = 
	    		programmingLanguageRepository.findById(
	    				updateProgrammingLanguageRequest.getId()).orElseThrow(() -> 
	    				new RuntimeException("Programming language not found"));
		programmingLanguage.setName(updateProgrammingLanguageRequest.getName());
		
		programmingLanguageRepository.save(programmingLanguage);
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages =
				programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponse =
				new ArrayList<GetAllProgrammingLanguagesResponse>();
		
		for (ProgrammingLanguage programmingLanguage : programmingLanguages) {
			GetAllProgrammingLanguagesResponse response = new GetAllProgrammingLanguagesResponse();
			response.setId(programmingLanguage.getId());
			response.setName(programmingLanguage.getName());
			getAllProgrammingLanguagesResponse.add(response);
		}
		
		return getAllProgrammingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		Optional<ProgrammingLanguage> programmingLanguage = 
				programmingLanguageRepository.findById(id);
		
		GetByIdProgrammingLanguageResponse response = new GetByIdProgrammingLanguageResponse();
		response.setId(programmingLanguage.get().getId());
		response.setName(programmingLanguage.get().getName());
		
		return response;
	}

	

}
