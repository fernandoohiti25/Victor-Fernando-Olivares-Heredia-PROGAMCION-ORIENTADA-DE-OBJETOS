package org.example;

public class Pelicula extends Contenido {

    private String director;

    public Pelicula(String titulo, String genero, double duracion, String director) {
        super(titulo, genero, duracion);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo película: " + getTitulo());
    }

    @Override
    public String obtenerTipoContenido() {
        return "Película";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Director: " + director;
    }

    @Override
    public String toString() {
        return "PELÍCULA\n" +
                super.toString() +
                "Director: " + director + "\n";
    }
}