package dev.java10x.EventClean.infraestructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.BuscarEventoUseCase;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import dev.java10x.EventClean.core.usecases.FiltrarIdentificadorEventoUseCase;
import dev.java10x.EventClean.infraestructure.dtos.EventoDto;
import dev.java10x.EventClean.infraestructure.mapper.EventoDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/vi")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;
    private final BuscarEventoUseCase buscarEventoUseCase;
    private final FiltrarIdentificadorEventoUseCase filtrarIdentificaddorUseCase;

    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper eventoDtoMapper, BuscarEventoUseCase buscarEventoUseCase, FiltrarIdentificadorEventoUseCase filtrarIdentificaddorUseCase) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
        this.buscarEventoUseCase = buscarEventoUseCase;
        this.filtrarIdentificaddorUseCase = filtrarIdentificaddorUseCase;
    }

    @PostMapping("/criarevento")
    public ResponseEntity<Map<String, Object>> criarEvento(@RequestBody EventoDto dto){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toDomain(dto));
        Map<String, Object> response = new HashMap<>();
        response.put("Message:", "Evento cadastrado com sucesso no banco de dados");
        response.put("Dados do evento", eventoDtoMapper.toDto(novoEvento));
        return ResponseEntity.ok(response);

    }

    @GetMapping("/buscarevento")
    public List<EventoDto> buscarEventos(){
        return buscarEventoUseCase.execute().stream().map(eventoDtoMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/identificador/{identificador}")
    public ResponseEntity<Evento> buscarPorIdentificador(@PathVariable String identificador){
        Evento evento = filtrarIdentificaddorUseCase.execute(identificador);
        return ResponseEntity.ok(evento);
    }
}
