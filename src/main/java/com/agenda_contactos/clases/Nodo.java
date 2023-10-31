package com.agenda_contactos.clases;

public class Nodo {
    private Nodo liga;
    private Contacto contacto;

    public Nodo(Contacto contacto){
        this.liga = null;
        this.contacto = contacto;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
}
