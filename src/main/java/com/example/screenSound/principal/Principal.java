package com.example.screenSound.principal;

import com.example.screenSound.repository.ArtistaRepository;
import com.example.screenSound.repository.MusicaRepository;

public class Principal {
    private ArtistaRepository artistaRepository;
    private MusicaRepository musicaRepository;

    public Principal() {
    }

    public Principal(ArtistaRepository artistaRepository,
                     MusicaRepository musicaRepository) {
        this.artistaRepository = artistaRepository;
        this.musicaRepository = musicaRepository;
    }

    public void exibeMenu() {
        System.out.println("Hello World!");
    }
}
