package org.example.modelo;

public class Profesor extends PersonaUt {

    private int numEmpleado;
    private String nombreEmpleado;
    private String puesto;
    private double sueldo;

    public Profesor(){}

    public Profesor(String nombre, String curp, int numEmpleado,
                    String nombreEmpleado, String puesto, double sueldo) {

        super(nombre, curp);

        setNumEmpleado(numEmpleado);
        setNombreEmpleado(nombreEmpleado);
        setPuesto(puesto);
        setSueldo(sueldo);
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {

        if(numEmpleado > 0){
            this.numEmpleado = numEmpleado;
        }else{
            System.out.println("Número de empleado inválido");
        }

    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {

        if(nombreEmpleado != null &&
                !nombreEmpleado.trim().isEmpty()){

            this.nombreEmpleado = nombreEmpleado;

        }else{

            System.out.println("Nombre del empleado inválido");

        }

    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {

        if(puesto != null &&
                !puesto.trim().isEmpty()){

            this.puesto = puesto;

        }else{

            System.out.println("Puesto inválido");

        }

    }

    public double getSueldo() {

        String formato = String.format("%.2f", sueldo);

        return Double.parseDouble(formato);

    }

    public void setSueldo(double sueldo) {

        if(sueldo > 0){

            this.sueldo = sueldo;

        }else{

            System.out.println("Sueldo inválido");

        }

    }

    @Override
    public String toString() {

        return "Número de Empleado: " + getNumEmpleado() + "\n" +
                super.toString() + "\n" +
                "Nombre del Empleado: " + getNombreEmpleado() + "\n" +
                "Puesto: " + getPuesto() + "\n" +
                "Sueldo: $" + getSueldo() + "\n" +
                "======================================";

    }
}