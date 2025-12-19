package com.example.screenSound.principal;

import com.example.screenSound.model.Artista;
import com.example.screenSound.model.Musica;
import com.example.screenSound.model.TipoArtista;
import com.example.screenSound.repository.ArtistaRepository;
import com.example.screenSound.repository.MusicaRepository;

import java.util.*;

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
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusicas();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    listarMusicasPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }

        }
    }

    private void cadastrarArtistas() {
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

    private void cadastrarMusicas() {
        Set<Musica> musicas = new HashSet<>();
        String opcao = "S";
        Optional<Artista> artista = Optional.empty();

        System.out.println("Qual é o nome do artista?");
        while (true) {
            var nomeArtista = scanner.nextLine();

            artista = artistaRepository.procurarArtista(nomeArtista);

            if (artista.isPresent()) {
                System.out.println("Artista encontrado: " + artista.get().getNome());
                break;
            } else {
                System.out.println("Artista não encontrado!");
            }
        }

        System.out.println("\n-----Cadastro de músicas -----\n");

        while (opcao.equalsIgnoreCase("S")) {
            System.out.println("Qual é o nome da música?");
            var nomeMusica = scanner.nextLine();

            System.out.println("Qual é o nome do álbum?");
            var nomeAlbum = scanner.nextLine();

            Musica novaMusica = new Musica(nomeMusica, nomeAlbum, artista.get());
            musicas.add(novaMusica);

            System.out.println("Deseja cadastrar mais músicas? (S/N)");
            opcao = scanner.nextLine().trim();
        }

        musicaRepository.saveAll(musicas);
        System.out.println("Músicas cadastradas com sucesso!");
    }

    private void listarMusicas() {
        List<Musica> musicasBuscadas = musicaRepository.buscarMusicasComArtista();

        System.out.println("\n-----Músicas-----");
        musicasBuscadas.forEach(m -> {
            System.out.println("Música: " + m.getTitulo() + " - " +
                    "álbum: " + m.getAlbum() + " - " +
                    "artista: " + m.getArtista().getNome()
                    );
        });
    }

    private void listarMusicasPorArtista() {
        System.out.println("Digite o nome do artista:");

        while (true) {
        var nomeArtista = scanner.nextLine();
        List<Musica> musicasEncontradas = musicaRepository.buscarMusicasPorArtista(nomeArtista);

            if (musicasEncontradas.isEmpty()) {
                System.out.println("Nenhuma música encontrada para o artista " + nomeArtista);
            } else {
                musicasEncontradas.forEach(m -> {
                    System.out.println("Música: " + m.getTitulo() +
                            " - " + "álbum: " + m.getAlbum());
                });
                break;
            }
        }
    }
}
