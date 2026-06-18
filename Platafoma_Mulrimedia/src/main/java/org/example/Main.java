package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Contenido> contenidos = new ArrayList<>();

        int opcion;

        do {

            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Registrar película");
            System.out.println("2. Registrar serie");
            System.out.println("3. Registrar podcast");
            System.out.println("4. Mostrar todo el contenido registrado");
            System.out.println("5. Reproducir todo el contenido");
            System.out.println("6. Salir");
            System.out.println("7. Mostrar por tipo");
            System.out.println("8. Mostrar tiempo total");
            System.out.println("9. Mostrar episodios de series");
            System.out.println("10. Mostrar datos generales");
            System.out.println("11. Mostrar datos particulares");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Título: ");
                    String tituloP = sc.nextLine();

                    System.out.print("Género: ");
                    String generoP = sc.nextLine();

                    System.out.print("Duración: ");
                    double duracionP = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Director: ");
                    String director = sc.nextLine();

                    contenidos.add(
                            new Pelicula(
                                    tituloP,
                                    generoP,
                                    duracionP,
                                    director
                            )
                    );

                    System.out.println("Película registrada.");
                    break;

                case 2:

                    System.out.print("Título: ");
                    String tituloS = sc.nextLine();

                    System.out.print("Género: ");
                    String generoS = sc.nextLine();

                    System.out.print("Duración por episodio: ");
                    double duracionS = sc.nextDouble();

                    System.out.print("Número de temporadas: ");
                    int temporadas = sc.nextInt();

                    System.out.print("Número de episodios: ");
                    int episodios = sc.nextInt();

                    sc.nextLine();

                    contenidos.add(
                            new Serie(
                                    tituloS,
                                    generoS,
                                    duracionS,
                                    temporadas,
                                    episodios
                            )
                    );

                    System.out.println("Serie registrada.");
                    break;

                case 3:

                    System.out.print("Título: ");
                    String tituloPod = sc.nextLine();

                    System.out.print("Género: ");
                    String generoPod = sc.nextLine();

                    System.out.print("Duración: ");
                    double duracionPod = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nombre del presentador: ");
                    String presentador = sc.nextLine();

                    contenidos.add(
                            new Podcast(
                                    tituloPod,
                                    generoPod,
                                    duracionPod,
                                    presentador
                            )
                    );

                    System.out.println("Podcast registrado.");
                    break;

                case 4:

                    if (contenidos.isEmpty()) {
                        System.out.println("No hay contenido registrado.");
                    } else {

                        for (Contenido c : contenidos) {

                            System.out.println("--------------------");
                            System.out.println(c);
                        }
                    }

                    break;

                case 5:

                    if (contenidos.isEmpty()) {

                        System.out.println("No hay contenido para reproducir.");

                    } else {

                        for (Contenido c : contenidos) {
                            c.reproducir();
                        }
                    }

                    break;

                case 7:

                    System.out.println("1. Películas");
                    System.out.println("2. Series");
                    System.out.println("3. Podcasts");
                    System.out.print("Seleccione: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    for (Contenido c : contenidos) {

                        if (tipo == 1 &&
                                c.obtenerTipoContenido().equals("Película")) {
                            System.out.println(c);
                        }

                        if (tipo == 2 &&
                                c.obtenerTipoContenido().equals("Serie")) {
                            System.out.println(c);
                        }

                        if (tipo == 3 &&
                                c.obtenerTipoContenido().equals("Podcast")) {
                            System.out.println(c);
                        }
                    }

                    break;

                case 8:

                    for (Contenido c : contenidos) {

                        System.out.println(
                                c.getTitulo() +
                                        " -> Tiempo total: " +
                                        c.obtenerTiempoTotal() +
                                        " minutos"
                        );
                    }

                    break;

                case 9:

                    for (Contenido c : contenidos) {

                        if (c instanceof Serie) {

                            System.out.println(
                                    c.getTitulo() +
                                            " -> Episodios: " +
                                            c.numeroEpisodios()
                            );
                        }
                    }

                    break;

                case 10:

                    for (Contenido c : contenidos) {

                        System.out.println("--------------------");
                        System.out.println(c.obtenerDatosGenerales());
                    }

                    break;

                case 11:

                    for (Contenido c : contenidos) {

                        System.out.println("--------------------");
                        System.out.println(c.obtenerDatosParticulares());
                    }

                    break;

                case 6:

                    System.out.println("Saliendo del sistema...");
                    break;

                default:

                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        sc.close();
    }
}