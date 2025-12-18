package com.example.screenSound.model;

public class Musica {
    private String titulo;
    private String album;
    private Artista artista;

    public Musica() {}

    public Musica(String titulo, String album, Artista artista) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Musica{" +
                "titulo='" + titulo + '\'' +
                ", album='" + album + '\'' +
                ", artista=" + artista +
                '}';
    }
}
