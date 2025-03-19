package dev.java10x.EventClean.infraestructure.presentation;
import dev.java10x.EventClean.core.entities.Evento;
import dev.java10x.EventClean.core.usecases.CriarEventoUseCase;
import dev.java10x.EventClean.infraestructure.dtos.EventoDto;
import dev.java10x.EventClean.infraestructure.mapper.EventoDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi")
public class EventoController {

    private final CriarEventoUseCase criarEventoUseCase;
    private final EventoDtoMapper eventoDtoMapper;

    public EventoController(CriarEventoUseCase criarEventoUseCase, EventoDtoMapper eventoDtoMapper) {
        this.criarEventoUseCase = criarEventoUseCase;
        this.eventoDtoMapper = eventoDtoMapper;
    }

    @PostMapping("/criarevento")
    public EventoDto criarEvento(@RequestBody EventoDto dto){
        Evento novoEvento = criarEventoUseCase.execute(eventoDtoMapper.toDomain(dto));
        return eventoDtoMapper.toDto(novoEvento);

    }

    @GetMapping
    public String listarEvento(){
        return listarEvento();
    }

}
