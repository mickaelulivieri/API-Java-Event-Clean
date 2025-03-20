package dev.java10x.EventClean.core.gateway;

import dev.java10x.EventClean.core.entities.Evento;

import java.util.List;

public interface EventoGateway {

    public Evento criarEvento(Evento evento);

    List<Evento> buscarEventos();
    boolean existePorIdentificador(String identificador);
}
