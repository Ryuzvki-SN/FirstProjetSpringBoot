package self.employed.firstprojetspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import self.employed.firstprojetspringboot.model.RendezVous;

import java.util.Optional;

public interface RendezVousRepository extends JpaRepository<RendezVous, Long> {
    Optional<RendezVous> findByCodeRendezVous(String codeRendezVous);

}
