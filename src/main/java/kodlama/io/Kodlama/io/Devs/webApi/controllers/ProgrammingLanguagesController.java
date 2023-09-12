package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateProgrammingLanguageRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedProgrammingLanguageResponse;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private final ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}


	@GetMapping("/getall")
	@ResponseStatus(code=HttpStatus.OK)
	public List<GetAllProgrammingLanguagesResponse> getAll(){
		List<GetAllProgrammingLanguagesResponse> result = programmingLanguageService.getAll();
		return result;
	}
	
	@GetMapping("/getbyid{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public GetByIdProgrammingLanguageResponse getById(@PathVariable int id){
		GetByIdProgrammingLanguageResponse result = programmingLanguageService.getById(id);
		return result;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CreatedProgrammingLanguageResponse add(@RequestBody @Valid CreateProgrammingLanguageRequest createProgrammingLanguageRequest){
		CreatedProgrammingLanguageResponse result = 
				programmingLanguageService.add(createProgrammingLanguageRequest);
		return result;
		
	}
	
	@PutMapping("/update")
	@ResponseStatus(code=HttpStatus.OK)
	public UpdatedProgrammingLanguageResponse update(@RequestBody UpdateProgrammingLanguageRequest updateProgrammingLanguageRequest){
		UpdatedProgrammingLanguageResponse result =
				programmingLanguageService.update(updateProgrammingLanguageRequest);
		return result;
	}
	
	@DeleteMapping("/delete{id}")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable int id){
		programmingLanguageService.delete(id);
		
	}
	
}
