package dev.java10x.EventClean.infraestructure.mapper;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.infraestructure.persistence.EventoEntity;
import org.springframework.stereotype.Component;

@Component
public class EventoEntityMapper {

    public EventoEntity toEntity(Evento evento){
        return new EventoEntity(
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

    public Evento toDomain(EventoEntity eventoEntity){
        return new Evento(
                eventoEntity.getId(),
                eventoEntity.getNome(),
                eventoEntity.getDescricao(),
                eventoEntity.getIdentificador(),
                eventoEntity.getDataInicio(),
                eventoEntity.getDataFim(),
                eventoEntity.getLocal(),
                eventoEntity.getOrganizador(),
                eventoEntity.getTipo()
        );

    }
}
