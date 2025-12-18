package com.example.screenSound.principal;

import com.example.screenSound.model.Artista;
import com.example.screenSound.model.TipoArtista;
import com.example.screenSound.repository.ArtistaRepository;
import com.example.screenSound.repository.MusicaRepository;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Principal {
    private final Scanner scanner = new Scanner(System.in);
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
        int opcao = -1;
        String menu = """
                
                ---- Screen Sound Músics ----
                
                1 - Cadastrar Artistas
                2 - Cadastrar Músicas
                3 - Listar Músicas 
                4 - Buscar músicas por artista
                5 - Pesquisar dados sobre um artista
                
                0 - Sair
                """;

        while (opcao != 0) {
            System.out.println(menu);
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarArtistas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void criarArtistas() {
        Set<Artista> artistas = new HashSet<>();
        String opcao = "S";

        while (opcao.equalsIgnoreCase("S")) {
            System.out.println("Qual é o nome do artista?");
            var nomeArtista = scanner.nextLine();

            System.out.println("Qual é o tipo desse artista? (solo, dupla, banda)");
            var tipo = scanner.nextLine();
            TipoArtista tipoArtista = TipoArtista.fromString(tipo);

            Artista artista = new Artista(nomeArtista, tipoArtista);
            artistas.add(artista);

            System.out.println("Cadastrar outro artista? (S/N)");
            opcao = scanner.nextLine().trim();
        }
        artistaRepository.saveAll(artistas);
        System.out.println("Artistas cadastrados com sucesso!");
    }
}
