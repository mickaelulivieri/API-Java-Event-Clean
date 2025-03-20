package dev.java10x.EventClean.infraestructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import dev.java10x.EventClean.infraestructure.dtos.EventoDto;
import dev.java10x.EventClean.infraestructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/vi")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUseCase buscarEventoUseCase;

    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper eventoDtoMapper, BuscarEventoUseCase buscarEventoUseCase) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
    }

    @PostMapping("/criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toDomain(dto));
        return eventoDtoMapper.toDto(novoEvento);

    }

    @GetMapping("/buscarevento")
    public List<EventoDto> buscarEventos(){
        return buscarEventoUseCase.execute().stream().map(eventoDtoMapper::toDto).collect(Collectors.toList());
    }

}
