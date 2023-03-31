package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programminglanguages")
public class ProgrammingLanguagesController {

	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		List<ProgrammingLanguage> programmingLanguages = programmingLanguageService.getAll();
		return programmingLanguages;
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id){
		ProgrammingLanguage programmingLanguage = programmingLanguageService.getById(id);
		return programmingLanguage;
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage){
		programmingLanguageService.add(programmingLanguage);
		
	}
	
	@PostMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage){
		programmingLanguageService.update(programmingLanguage);
		
	}
	
	@PostMapping("/delete")
	public void delete(int id){
		programmingLanguageService.delete(id);
		
	}
	
}
