package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.CreateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.DeleteTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.requests.UpdateTechnologyRequest;
import kodlama.io.Kodlama.io.Devs.business.responses.GetAllTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.GetByIdTechnologyResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/technologies")
@AllArgsConstructor
public class TechnologiesController {

	@Autowired
	private TechnologyService technologyService;
	
	@GetMapping("/getall")
	public List<GetAllTechnologiesResponse> getAll(){
		List<GetAllTechnologiesResponse> result = technologyService.getAll();
		return result;
	}
	
	@GetMapping("/getbyid")
	public GetByIdTechnologyResponse getById(int id){
		GetByIdTechnologyResponse result = technologyService.getById(id);
		return result;
	}
	
	@PostMapping("/add")
	public void add(CreateTechnologyRequest createTechnologyRequest){
		technologyService.add(createTechnologyRequest);
	}
	
	@PostMapping("/update")
	public void update(UpdateTechnologyRequest updateTechnologyRequest){
		technologyService.update(updateTechnologyRequest);
	}
	
	@PostMapping("/delete")
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest){
		technologyService.delete(deleteTechnologyRequest);
	}
}
