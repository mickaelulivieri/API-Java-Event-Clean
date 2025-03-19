package dev.java10x.EventClean.infraestructure.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infraestructure.dtos.EventoDto;
import org.springframework.stereotype.Component;

@Component
public class EventoDtoMapper {

    public EventoDto toDto(Evento evento){
        return new EventoDto(
                evento.id(),
                evento.nome(),
                evento.descricao(),
                evento.identificador(),
                evento.dataInicio(),
                evento.dataFim(),
                evento.local(),
                evento.organizador(),
                evento.tipo()
        );
    }

    public Evento toDomain(EventoDto eventoDto){
        return new Evento(
                eventoDto.id(),
                eventoDto.nome(),
                eventoDto.descricao(),
                eventoDto.identificador(),
                eventoDto.dataInicio(),
                eventoDto.dataFim(),
                eventoDto.local(),
                eventoDto.organizador(),
                eventoDto.tipo()
        );
    }
}
