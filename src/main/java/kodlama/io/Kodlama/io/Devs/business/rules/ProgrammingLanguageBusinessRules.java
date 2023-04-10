package kodlama.io.Kodlama.io.Devs.business.rules;

import kodlama.io.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProgrammingLanguageBusinessRules {
    private ProgrammingLanguageRepository programmingLanguageRepository;

    public void checkIfProgrammingLanguageExists(String name) {
        if (programmingLanguageRepository.existsByName(name)) {
            throw new BusinessException("Programming language name already exists.");
        }
    }
}
