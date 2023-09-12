package kodlama.io.Kodlama.io.Devs.business.rules;

import kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgrammingLanguageBusinessRules {
    private final ProgrammingLanguageRepository programmingLanguageRepository;

    public ProgrammingLanguageBusinessRules(ProgrammingLanguageRepository programmingLanguageRepository) {
        this.programmingLanguageRepository = programmingLanguageRepository;
    }

    public void checkIfProgrammingLanguageExists(String name) {
        if (programmingLanguageRepository.existsByName(name)) {
            throw new BusinessException("Programming language name already exists.");
        }
    }
}
