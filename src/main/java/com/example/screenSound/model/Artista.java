package com.example.screenSound.model;

import java.util.HashSet;
import java.util.Set;

public class Artista {
    private String nome;
    private TipoArtista tipo;
    private Set<Musica> musicas = new HashSet<>();

    public Artista() {}

    public Artista(String nome, TipoArtista tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public Set<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(Set<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", musicas=" + musicas +
                '}';
    }
}
