package org.example;

public class Podcast extends Contenido {

    private String nombrePresentador;

    public Podcast(String titulo, String genero,
                   double duracion, String nombrePresentador) {

        super(titulo, genero, duracion);
        this.nombrePresentador = nombrePresentador;
    }

    public String getNombrePresentador() {
        return nombrePresentador;
    }

    public void setNombrePresentador(String nombrePresentador) {
        this.nombrePresentador = nombrePresentador;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo podcast: " + getTitulo());
    }

    @Override
    public String obtenerTipoContenido() {
        return "Podcast";
    }

    @Override
    public String obtenerDatosParticulares() {
        return "Presentador: " + nombrePresentador;
    }

    @Override
    public String toString() {
        return "PODCAST\n" +
                super.toString() +
                "Presentador: " + nombrePresentador + "\n";
    }
}
