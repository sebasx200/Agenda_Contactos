package com.agenda_contactos.clases;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.TextField;

public class ListaNodos {
    private Nodo punta;
    private final int maxContactos = 100;
    private int contador = 0;
    public ListaNodos(){
        this.punta = null;
    }
    public boolean listaVacia(){
        if(punta == null){
            return true;
        } else{
            return false;
        }
    }
    public void insertarNodo(Contacto contacto){
        if(existeContacto(contacto.getNombre())){
            boolean opcion= Mensajes.mensajeConfirmacion("Editar contacto","El contacto ingresado ya está registrado",
                    "¿Quiere editarlo con la información ingresada?");
            if(opcion){
                editarContacto(contacto.getNombre(), contacto);
            }
            return;
        }
        Nodo nuevoNodo = new Nodo(contacto);
        if(listaVacia()){
            punta = nuevoNodo;
            contador++;
        } else{
            nuevoNodo.setLiga(punta);
            punta = nuevoNodo;
            contador++;
        }
    }
    public String devolverContactos(){
        String salida = "";
        if(listaVacia()){
            Mensajes.mensajeAdvertencia("", "La lista está vacía");
        } else {
            Nodo p;
            p = punta;

            while(p != null) {
                salida = salida+p.getContacto() +"\n";
                p = p.getLiga();
            }
        }
        return salida;
    }
    public boolean existeContacto(String nombre){
        Nodo p = punta;
        while (p != null){
            if(p.getContacto().getNombre().equals(nombre)){
                return true;
            }
            p = p.getLiga();
        }
        return false;
    }

    public Contacto buscarContacto(String nombre) {
        Nodo p = punta;
        Contacto contactoEncontrado;
        while (p != null) {
            if (p.getContacto().getNombre().equals(nombre)){
                contactoEncontrado = new Contacto(p.getContacto());
                return contactoEncontrado;
            }
            p = p.getLiga();
        }
        return null;
    }
    public void getContador(){
        int cantidadContactos = maxContactos-contador;
        Mensajes.mensajeInformativo(null, "Cantidad de contactos en la agenda: "+contador +" contactos"+"\n"
        +"Puede añadir: " + cantidadContactos +" contactos nuevos");
    }

    public void editarContacto(String nombre, Contacto nuevoContacto) {
        Nodo p = punta;
        while (p != null) {
            if (p.getContacto().getNombre().equals(nombre)) {

                p.getContacto().setNombre(nuevoContacto.getNombre());
                p.getContacto().setNumero(nuevoContacto.getNumero());
                return;
            }
            p = p.getLiga();
        }
        System.out.println("Error: El contacto con el nombre especificado no existe.");
    }

    public int borrarContactoPorNombre(String nombre){
        if(listaVacia()) {
            return 0;
        }
        if(punta.getContacto().getNombre().equals(nombre)) {
            punta = punta.getLiga();
            contador--;
            return 1;
        }
        Nodo p = punta;
        while (p.getLiga() != null) {
            if (p.getLiga().getContacto().getNombre().equals(nombre)) {
                p.setLiga(p.getLiga().getLiga());
                contador--;
                return 1;
            }
            p = p.getLiga();

        }
        return -1;
    }
    public String buscarIniciales(String iniciales){
        String salida = "";
        Nodo p;
        p = punta;
        while(p != null) {
            if(p.getContacto().getNombre().startsWith(iniciales)) {
                salida = salida + p.getContacto() + "\n";
            }
            p = p.getLiga();
        }
        return salida;
    }
}