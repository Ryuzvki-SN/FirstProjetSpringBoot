package self.employed.firstprojetspringboot.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import self.employed.firstprojetspringboot.model.RendezVous;
import self.employed.firstprojetspringboot.service.RendezVousService;

import java.util.Collection;


@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api/v1/*")
@Tag(name = "Rendez Vous", description = "the Meeting API")
public class RendezVousController {

    private static final Logger logger = LoggerFactory.getLogger(RendezVousController.class);
    private final RendezVousService rendezVousService;

    @Autowired
    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @GetMapping("/rendezvous")
    public ResponseEntity<Collection<RendezVous>> getAllRendezVous() {
        logger.info("liste des rendez-vous" + rendezVousService.getAllRendezVous());
        return new ResponseEntity<>(rendezVousService.getAllRendezVous(), HttpStatus.FOUND);
    }

    @GetMapping("/rendezvous/{id}")
    public ResponseEntity<RendezVous> getRendezVousById( @PathVariable("id") Long id) {
        logger.info("rendez-vous" + rendezVousService.getRendezVousById(id));
        return new ResponseEntity<>(rendezVousService.getRendezVousById(id), HttpStatus.FOUND);
    }
    //Recuperer un rendez vous par son codeRendezVous
    @GetMapping("/rendezvous/{codeRendezVous}")
    public ResponseEntity<RendezVous> findRendezVousByCodeRendezVous(@PathVariable("codeRendezVous") String codeRendezVous) {
        logger.info("rendez-vous" + rendezVousService.findRendezVousByCodeRendezVous(codeRendezVous));
        return new ResponseEntity<>(rendezVousService.findRendezVousByCodeRendezVous(codeRendezVous), HttpStatus.FOUND);
    }
    // enregistrer un rendez vous
    @RequestMapping(value = "/rendezvous", method = {RequestMethod.POST})
    public ResponseEntity<RendezVous> saveRendezVous(@RequestBody RendezVous rendezVous) {
        logger.info("rendez-vous" + rendezVousService.saveRendezVous(rendezVous));
        return new ResponseEntity<>(rendezVousService.saveRendezVous(rendezVous), HttpStatus.CREATED);
    }

    // modifier un rendez vous
    @RequestMapping(value = "/rendezvous", method = {RequestMethod.PUT})
    public ResponseEntity<RendezVous> updateRendezVous(@RequestBody RendezVous rendezVous) {
        logger.info("rendez-vous" + rendezVousService.updateRendezVous(rendezVous));
        return new ResponseEntity<>(rendezVousService.updateRendezVous(rendezVous), HttpStatus.OK);
    }

    //Supprimer un rendez vous
    @DeleteMapping("/rendezvous/{id}")
    public ResponseEntity<RendezVous> deleteRendezVous(@PathVariable("id") Long id) {
        logger.info("rendez-vous supprime avec succes" );
        rendezVousService.deleteRendezVous(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }





}

