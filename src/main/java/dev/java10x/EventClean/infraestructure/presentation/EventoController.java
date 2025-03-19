package dev.java10x.EventClean.infraestructure.presentation;

import dev.java10x.EventClean.core.entities.Evento;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vi")
public class EventoController {


    @PostMapping("/criarevento")
    public String criarEvento(@RequestBody Evento evento){
        return "Evento criado";
    }


}
