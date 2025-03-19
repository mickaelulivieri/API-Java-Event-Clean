package dev.java10x.EventClean.infraestructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infraestructure.persistence.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventRepository eventRepository;



    @Override
    public Evento criarEvento(Evento evento){
        return eventRepository.save();

    }

}
