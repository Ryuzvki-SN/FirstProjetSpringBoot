package self.employed.firstprojetspringboot.service;

import self.employed.firstprojetspringboot.model.RendezVous;

import java.util.Collection;

public interface RendezVousService {
    Collection<RendezVous> getAllRendezVous();
    RendezVous saveRendezVous(RendezVous rendezVous);
    RendezVous updateRendezVous(RendezVous rendezVous);
    RendezVous getRendezVousById(Long id);
    RendezVous findRendezVousByCodeRendezVous(String codeRendezVous);
    void deleteRendezVous(Long id);
}
