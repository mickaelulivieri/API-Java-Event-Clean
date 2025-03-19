package dev.java10x.EventClean.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventoEntity, Long> {
}