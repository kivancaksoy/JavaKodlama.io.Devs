package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.rules.ProgrammingLanguageBusinessRules;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private final ProgrammingLanguageRepository programmingLanguageRepository;
	private final ModelMapperService modelMapperService;
	private final ProgrammingLanguageBusinessRules programmingLanguageBusinessRules;

	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository, ModelMapperService modelMapperService, ProgrammingLanguageBusinessRules programmingLanguageBusinessRules) {
		this.programmingLanguageRepository = programmingLanguageRepository;
		this.modelMapperService = modelMapperService;
		this.programmingLanguageBusinessRules = programmingLanguageBusinessRules;
	}

	@Override
	public CreatedProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest) {
		programmingLanguageBusinessRules.checkIfProgrammingLanguageExists(createProgrammingLanguageRequest.getName());

		ProgrammingLanguage programmingLanguage = 
	    		modelMapperService.forRequest().map(createProgrammingLanguageRequest, ProgrammingLanguage.class);
	    ProgrammingLanguage createdProgrammingLanguage =
	    		programmingLanguageRepository.save(programmingLanguage);
	    CreatedProgrammingLanguageResponse createdProgrammingLanguageResponse =
	    		modelMapperService.forResponse().map(createdProgrammingLanguage, CreatedProgrammingLanguageResponse.class);
	    
	    return createdProgrammingLanguageResponse;
		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.deleteById(id);
	}

	@Override
	public UpdatedProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest) {
	    ProgrammingLanguage programmingLanguage = 
	    		modelMapperService.forRequest().map(updateProgrammingLanguageRequest, ProgrammingLanguage.class);
	    ProgrammingLanguage updatedProgrammingLanguage =
	    		programmingLanguageRepository.save(programmingLanguage);
	    UpdatedProgrammingLanguageResponse updatedProgrammingLanguageResponse =
	    		modelMapperService.forResponse().map(updatedProgrammingLanguage, UpdatedProgrammingLanguageResponse.class);
	    
	    return updatedProgrammingLanguageResponse;
		
	}

	@Override
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		List<ProgrammingLanguage> programmingLanguages =
				programmingLanguageRepository.findAll();
		List<GetAllProgrammingLanguagesResponse> getAllProgrammingLanguagesResponse =
				programmingLanguages.stream().map(programmingLanguage ->
					modelMapperService.forResponse()
					.map(programmingLanguage, GetAllProgrammingLanguagesResponse.class))
					.toList();
			
		return getAllProgrammingLanguagesResponse;
	}

	@Override
	public GetByIdProgrammingLanguageResponse getById(int id) {
		ProgrammingLanguage programmingLanguage =
				programmingLanguageRepository.findById(id).orElseThrow(() ->
						new RuntimeException("Programming language not found"));
		GetByIdProgrammingLanguageResponse getByIdProgrammingLanguageResponse =
				modelMapperService.forResponse().map(programmingLanguage, GetByIdProgrammingLanguageResponse.class);
		
		return  getByIdProgrammingLanguageResponse;
	}

	

}
