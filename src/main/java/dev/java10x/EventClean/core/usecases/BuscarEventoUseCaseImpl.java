package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BuscarEventoUseCaseImpl implements BuscarEventoUseCase {

    private final EventoGateway eventoGateway;

    @Override
    public List<Evento> execute() {
        return List.of();
    }
}
