package dev.java10x.EventClean.infraestructure.dtos;

import dev.java10x.EventClean.core.enums.TipoEvento;

import java.time.LocalDateTime;

public record EventoDto(Long id,
                        String nome,
                        String descricao,
                        String identificador,
                        LocalDateTime dataInicio,
                        LocalDateTime dataFim,
                        String local,
                        String organizador,
                        TipoEvento tipo) {
}
