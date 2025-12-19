package com.example.screenSound.repository;

import com.example.screenSound.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long> {
    @Query("SELECT m FROM Musica m JOIN FETCH m.artista")
    List<Musica> buscarMusicasComArtista();

    @Query("SELECT m FROM Musica m WHERE m.artista.nome ILIKE :nomeArtista")
    List<Musica> buscarMusicasPorArtista(String nomeArtista);
}
