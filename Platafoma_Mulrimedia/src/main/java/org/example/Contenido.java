package org.example;

public class Contenido {
    private String titulo;
    private String genero;
    private double duracion;

    public Contenido() {
    }

    public Contenido(String titulo, String genero, double duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void reproducir() {
        System.out.println("Reproduciendo: " + titulo);
    }
    public String obtenerTipoContenido() {
        return "Contenido";
    }

    public double obtenerTiempoTotal() {
        return duracion;
    }

    public int numeroEpisodios() {
        return 0;
    }

    public String obtenerDatosGenerales() {
        return "Título: " + titulo +
                "\nGénero: " + genero +
                "\nDuración: " + duracion + " min";
    }

    public String obtenerDatosParticulares() {
        return "Sin datos particulares";
    }

    @Override
    public String toString() {
        return "Título: " + titulo + "\n" +
                "Género: " + genero + "\n" +
                "Duración: " + duracion + " min\n";
    }

}
