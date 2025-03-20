package dev.java10x.EventClean.infraestructure.beans;

import dev.java10x.EventClean.core.gateway.EventoGateway;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCaseImpl;
import dev.java10x.EventClean.core.usecases.CriarEventoCaseImpl;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarEventoUseCase criarEvento(EventoGateway eventoGateway){
        return new CriarEventoCaseImpl(eventoGateway);
    }

    @Bean
    public BuscarEventoUseCase buscarEventoUseCase(EventoGateway eventoGateway){
        return new BuscarEventoUseCaseImpl(eventoGateway);
    }


}
