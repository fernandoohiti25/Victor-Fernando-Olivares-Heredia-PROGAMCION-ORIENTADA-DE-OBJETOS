package org.example.modelo;

public class Alumno extends PersonaUt implements Ensenable, Evaluable {

    private int numExpediente;
    private String grupo;
    private double promedio;

    public Alumno(){}

    public Alumno(String nombre, String curp, int numExpediente, String grupo, double promedio) {

        super(nombre, curp);
        setNumExpediente(numExpediente);
        setGrupo(grupo);
        setPromedio(promedio);
    }

    public int getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(int numExpediente) {

        if(numExpediente > 0){
            this.numExpediente = numExpediente;
        }else{
            System.out.println("Número de expediente inválido");
        }

    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {

        if(grupo != null && !grupo.trim().isEmpty()){
            this.grupo = grupo;
        }else{
            System.out.println("El grupo es requerido");
        }

    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {

        if(promedio >= 0 && promedio <= 10){
            this.promedio = promedio;
        }else{
            System.out.println("Promedio inválido");
        }

    }

    @Override
    public String mostrarTipoPersona() {
        return "===== ALUMNO =====";
    }

    @Override
    public String aprender() {
        return "El alumno está aprendiendo.";
    }

    @Override
    public String recibirEvaluacion() {
        return "El alumno recibió una evaluación.";
    }

    @Override
    public String toString() {

        return super.toString() + "\n" +
                "Número de Expediente: " + getNumExpediente() + "\n" +
                "Grupo: " + getGrupo() + "\n" +
                "Promedio: " + getPromedio() + "\n" +
                aprender() + "\n" +
                recibirEvaluacion() + "\n" +
                "======================================";
    }
}
