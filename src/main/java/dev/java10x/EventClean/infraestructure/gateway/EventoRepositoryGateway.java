package dev.java10x.EventClean.infraestructure.gateway;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infraestructure.mapper.EventoEntityMapper;
import dev.java10x.EventClean.infraestructure.persistence.EventRepository;
import dev.java10x.EventClean.infraestructure.persistence.EventoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Evento> buscarEventos(){
        return eventRepository.findAll().stream()
                .map(eventoEntityMapper::toDomain).toList();
    }

    @Override
    public boolean existePorIdentificador(String identificador) {
        return eventRepository.findAll().stream()
                .anyMatch(evento -> evento.getIdentificador().equals(identificador));
    }

    @Override
    public Optional<Evento> filtrarPorIdentificador(String identificador) {
        return eventRepository.findByIdentificador(identificador);
    }


}
