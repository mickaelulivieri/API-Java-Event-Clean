package dev.java10x.EventClean.core.usecases;

import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.infraestructure.exception.NotFoundEventException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FiltrarIdentificadorEventoUseCaseImpl implements FiltrarIdentificadorEventoUseCase {


    private final EventoGateway eventoGateway;

    @Override
    public Evento execute(String identificador) {
        return eventoGateway.filtrarPorIdentificador(identificador)
                .orElseThrow(() -> new NotFoundEventException("Evento com identificador" + identificador + "nao encontrado"));
    }

}
