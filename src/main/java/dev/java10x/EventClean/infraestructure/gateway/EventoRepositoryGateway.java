package dev.java10x.EventClean.infraestructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infraestructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infraestructure.persistence.EventRepository;
import dev.java10x.EventClean.infraestructure.persistence.EventoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventoRepositoryGateway implements EventoGateway {

    private final EventRepository eventRepository;
    private final EventoEntityMapper eventoEntityMapper;



    @Override
    public Evento criarEvento(Evento evento){
        EventoEntity entity = eventoEntityMapper.toEntity(evento);
        EventoEntity novoEvento = eventRepository.save(entity);
        return eventoEntityMapper.toDomain(novoEvento);

    }

}
