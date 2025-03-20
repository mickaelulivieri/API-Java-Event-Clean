package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infraestructure.exception.DuplicateEventException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarEventoCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    @Override
    public Evento execute(Evento evento){
        if (eventoGateway.existePorIdentificador(evento.identificador())) {
            throw new DuplicateEventException("O identificador número " + evento.identificador() + " já está cadastrado.");
        }

        eventoGateway.criarEvento(evento);

        return evento;
    }
}