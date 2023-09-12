package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

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

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.CreatedTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.UpdatedTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

	private final TechnologyService technologyService;

	public TechnologiesController(TechnologyService technologyService) {
		this.technologyService = technologyService;
	}

	@GetMapping("/getall")
	@ResponseStatus(code=HttpStatus.OK)
	public List<GetAllTechnologiesResponse> getAll(){
		List<GetAllTechnologiesResponse> result = technologyService.getAll();
		return result;
	}
	
	@GetMapping("/getbyid")
	@ResponseStatus(code=HttpStatus.OK)
	public GetByIdTechnologyResponse getById(@PathVariable int id){
		GetByIdTechnologyResponse result = technologyService.getById(id);
		return result;
	}
	
	@PostMapping("/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public CreatedTechnologyResponse add(@RequestBody CreateTechnologyRequest createTechnologyRequest){
		CreatedTechnologyResponse result =
				technologyService.add(createTechnologyRequest);
		return result;
	}
	
	@PutMapping("/update")
	@ResponseStatus(code=HttpStatus.OK)
	public UpdatedTechnologyResponse update(@RequestBody UpdateTechnologyRequest updateTechnologyRequest){
		UpdatedTechnologyResponse result =
				technologyService.update(updateTechnologyRequest);
		return result;
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(code=HttpStatus.OK)
	public void delete(@PathVariable int id){
		technologyService.delete(id);
	}
}
