package self.employed.firstprojetspringboot.controller;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins="*")
public class DefaultController {
    private static final Logger logger = LoggerFactory.getLogger(DefaultController.class);

    @GetMapping(value = {"/","/index", "/api/v1/"})
    public ResponseEntity<String> index() {
        logger.info("Welcome to the api...");
        return new ResponseEntity<>("Welcome to the api...", HttpStatus.OK);
    }
}
