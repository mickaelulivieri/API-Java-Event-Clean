package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CriarEventoCaseImpl implements CriarEventoUseCase {

    private final EventoGateway eventoGateway;

    @Override
    public Evento execute(Evento evento){
        return eventoGateway.criarEvento(evento);
    }

}
