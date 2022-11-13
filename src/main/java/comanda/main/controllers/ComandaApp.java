package comanda.main.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:3000")/*Habilita para inyectar datos de la api en la página*/
@Controller
@RequestMapping(path="/comanda")
public abstract class ComandaApp {

}
