package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedProgrammingLanguageResponse;

public interface ProgrammingLanguageService {
	CreatedProgrammingLanguageResponse add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest);
	void delete(int id);
	UpdatedProgrammingLanguageResponse update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest);
	
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
}
