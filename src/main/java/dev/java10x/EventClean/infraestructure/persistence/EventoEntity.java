package dev.java10x.EventClean.infraestructure.persistence;

import dev.java10x.EventClean.core.enums.TipoEvento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventoEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "Description")
    private String descricao;

    @Column(name = "Identifier")
    private String identificador;

    @Column(name = "Data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "Data_fim")
    private LocalDateTime dataFim;

    @Column(name = "Local")
    private String local;

    @Column(name = "Organizador")
    private String organizador;

    @Column(name = "Tipo_de_evento")
    private TipoEvento tipo;

}
