package com.agenda_contactos.clases;

public class Contacto {

    private String nombre;
    private String numero;

    public Contacto(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
    public Contacto(Contacto contacto){
        this.nombre = contacto.getNombre();
        this.numero = contacto.getNumero();
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nombre + " " + numero;
    }
}
