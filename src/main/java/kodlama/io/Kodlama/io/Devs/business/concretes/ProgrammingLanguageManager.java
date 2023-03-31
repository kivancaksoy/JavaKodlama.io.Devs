package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		if(programmingLanguageNameNotEmptyOrNull(programmingLanguage)) {
			programmingLanguageRepository.add(programmingLanguage);
		}		
	}

	@Override
	public void delete(int id) {
		programmingLanguageRepository.delete(id);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		if(programmingLanguageNameNotEmptyOrNull(programmingLanguage)) {
			programmingLanguageRepository.update(programmingLanguage);
		}		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguageRepository.getAll();

	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageRepository.getById(id);
	}
	
	private boolean programmingLanguageNameNotEmptyOrNull(ProgrammingLanguage programmingLanguage) {
		if(programmingLanguage.getName() == null || programmingLanguage.getName() == "") {
			return false;
		}
		List<ProgrammingLanguage> programmingLanguages = getAll();
		
		for (ProgrammingLanguage _programmingLanguage : programmingLanguages) {
			if (_programmingLanguage.getName().equals(programmingLanguage.getName())) {
				return false;
			}
		}
		return true;
	}

}
