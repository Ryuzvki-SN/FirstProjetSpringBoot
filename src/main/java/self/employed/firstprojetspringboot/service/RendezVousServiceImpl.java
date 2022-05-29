package self.employed.firstprojetspringboot.service;

import org.apache.commons.collections4.IterableUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import self.employed.firstprojetspringboot.dao.RendezVousRepository;
import self.employed.firstprojetspringboot.exceptions.ResourceNotFoundException;
import self.employed.firstprojetspringboot.model.RendezVous;

import java.util.Collection;
import java.util.UUID;

@Service("rendezVousService")
public class RendezVousServiceImpl implements RendezVousService {

    public final RendezVousRepository rendezVousRepository;

    @Autowired
    public RendezVousServiceImpl(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    @Override
    public Collection<RendezVous> getAllRendezVous() {

        return IterableUtils.toList(rendezVousRepository.findAll());
    }

    @Override
    @Transactional
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setCodeRendezVous(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }
 @Override
    @Transactional
    public RendezVous updateRendezVous(RendezVous rendezVous) {
        return rendezVousRepository
                .findById(rendezVous.getId())
                .map(rendezVous1 -> rendezVousRepository.save(rendezVous))
                .orElseThrow(() -> new ResourceNotFoundException("RendezVous not found"));
    }

    @Override
    public RendezVous getRendezVousById(Long id) {
        return rendezVousRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RendezVous not found"));
    }

    @Override
    public RendezVous findRendezVousByCodeRendezVous(String codeRendezVous) {

        return rendezVousRepository
                .findByCodeRendezVous(codeRendezVous)
                .orElseThrow(() -> new ResourceNotFoundException("Rendez Vous not found"));
    }

    @Override
    @Transactional
    public void deleteRendezVous(Long id) {
        rendezVousRepository
                .findById(id)
                .map(rendezVous -> {
                    rendezVousRepository.delete(rendezVous);
                    return rendezVous;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Rendez Vous not found"));
    }


}
