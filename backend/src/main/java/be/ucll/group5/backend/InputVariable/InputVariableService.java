package be.ucll.group5.backend.InputVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InputVariableService {

    @Autowired
    private InputVariableRepository inputVariableRepository;

    public List<InputVariable> findAll() {
        return inputVariableRepository.findAll();
    }

    public Optional<InputVariable> findById(Long id) {
        return inputVariableRepository.findById(id);
    }

    public InputVariable save(InputVariable inputVariable) {
        return inputVariableRepository.save(inputVariable);
    }

    public void deleteById(Long id) {
        inputVariableRepository.deleteById(id);
    }
}
