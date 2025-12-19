package com.example.screenSound.repository;

import com.example.screenSound.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
    @Query("SELECT a FROM Artista a WHERE a.nome ILIKE :nomeArtista")
    Optional<Artista> procurarArtista(@Param("nomeArtista") String nomeArtista);
}
