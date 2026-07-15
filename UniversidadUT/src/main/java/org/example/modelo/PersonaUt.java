package org.example.modelo;

public abstract class PersonaUt {

    private String nombre;
    private String curp;

    public PersonaUt(){}

    public PersonaUt(String nombre, String curp){
        setNombre(nombre);
        setCurp(curp);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if(nombre != null && !nombre.trim().isEmpty()){
            this.nombre = nombre;
        }else{
            System.out.println("Nombre inválido");
        }

    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {

        if(curp != null && curp.length() == 18){
            this.curp = curp;
        }else{
            System.out.println("CURP inválida");
        }

    }

    public abstract String mostrarTipoPersona();

    @Override
    public String toString() {

        return mostrarTipoPersona() + "\n" +
                "Nombre: " + getNombre() + "\n" +
                "CURP: " + getCurp();

    }

}