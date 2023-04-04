package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/programminglanguages")
@AllArgsConstructor
public class ProgrammingLanguagesController {

	@Autowired
	private ProgrammingLanguageService programmingLanguageService;

	
	@GetMapping("/getall")
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		List<GetAllProgrammingLanguagesResponse> result = programmingLanguageService.getAll();
		return result;
	}
	
	@GetMapping("/getbyid")
	public GetByIdProgrammingLanguageResponse getById(int id){
		GetByIdProgrammingLanguageResponse result = programmingLanguageService.getById(id);
		return result;
	}
	
	@PostMapping("/add")
	public void add(CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		programmingLanguageService.add(createProgrammingLanguageRequest);
		
	}
	
	@PostMapping("/update")
	public void update(UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
		programmingLanguageService.update(updateProgrammingLanguageRequest);
		
	}
	
	@PostMapping("/delete")
	public void delete(DeleteProgrammingLanguageRequest deleteProgrammingLanguageRequest){
		programmingLanguageService.delete(deleteProgrammingLanguageRequest);
		
	}
	
}
