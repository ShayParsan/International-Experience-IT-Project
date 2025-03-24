package be.ucll.group5.backend.InputVariable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputVariableRepository extends JpaRepository<InputVariable, Long> {
    // Custom database queries can be defined here
}
