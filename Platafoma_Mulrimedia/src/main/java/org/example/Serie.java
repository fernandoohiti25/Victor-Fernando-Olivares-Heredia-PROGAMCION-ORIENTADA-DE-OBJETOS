package org.example;

public class Serie extends Contenido {

    private int numeroTemporadas;
    private int numeroEpisodios;

    public Serie(String titulo, String genero, double duracion,
                 int numeroTemporadas, int numeroEpisodios) {

        super(titulo, genero, duracion);
        this.numeroTemporadas = numeroTemporadas;
        this.numeroEpisodios = numeroEpisodios;
    }

    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    public void setNumeroTemporadas(int numeroTemporadas) {
        this.numeroTemporadas = numeroTemporadas;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo serie: " + getTitulo());
    }

    @Override
    public String obtenerTipoContenido() {
        return "Serie";
    }

    @Override
    public int numeroEpisodios() {
        return numeroEpisodios;
    }

    @Override
    public double obtenerTiempoTotal() {
        return getDuracion() * numeroEpisodios;
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Temporadas: " + numeroTemporadas +
                "\nEpisodios: " + numeroEpisodios;
    }

    @Override
    public String toString() {
        return "SERIE\n" +
                super.toString() +
                "Temporadas: " + numeroTemporadas + "\n" +
                "Episodios: " + numeroEpisodios + "\n";
    }
}
