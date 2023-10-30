package com.agenda_contactos;

import com.agenda_contactos.clases.Contacto;
import com.agenda_contactos.clases.ListaNodos;
import com.agenda_contactos.clases.Mensajes;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controlador_Ventana {
    @FXML
    private TextField inputNombre, inputNumero, inputBuscar, inputNombreBorrar;
    @FXML
    private Button botonIngresar;
    @FXML
    private TextArea areaTexto;
    ListaNodos listaNodos = new ListaNodos();
    @FXML
    private void onBotonIngresarAction(){
        if(validarDatos()) {
            Contacto contacto;
            String nombre = inputNombre.getText();
            String numero = inputNumero.getText();
            contacto = new Contacto(nombre, numero);
            listaNodos.insertarNodo(contacto);
            inputNombre.setText("");
            inputNumero.setText("");
        }
    }
    @FXML
    private void onBotonActualizarAction(){
        areaTexto.clear();
        areaTexto.appendText(listaNodos.devolverContactos());
    }
    @FXML
    private void onBotonBuscarAction(){
        if(inputBuscar.getText().isEmpty()){
            Mensajes.mensajeError("", "El campo de búsquedas está vacío");
        } else{
            String nombre = inputBuscar.getText();
            Contacto resultado = listaNodos.buscarContacto(nombre);
            inputBuscar.setText("");
            if(resultado != null) {
                areaTexto.clear();
                areaTexto.appendText("El resultado de la búsqueda es " + resultado);
            } else{
                Mensajes.mensajeInformativo("", "Contacto no encontrado");
            }
        }
    }

    @FXML
    private void onBotonBorrarAction(){
        if(inputNombreBorrar.getText().isEmpty()){
            Mensajes.mensajeError("", "El campo de búsquedas está vacío");
        } else {
            int borrar = listaNodos.borrarContactoPorNombre(inputNombreBorrar.getText());
            inputNombreBorrar.setText("");
            if(borrar==1){
                Mensajes.mensajeInformativo("", "El contacto fue eliminado correctamente");
            } else{
                Mensajes.mensajeInformativo("", "Contacto no encontrado");
            }
        }
    }
    @FXML
    private void onBotonEstadoAction(){
        listaNodos.getContador();
    }
    private boolean validarDatos(){
        if(inputNombre.getText().isEmpty() || inputNumero.getText().isEmpty()) {
            Mensajes.mensajeError("", "Los campos están vacíos");
            return false;
        }
        if (!inputNumero.getText().matches("^[0-9]*$")) {
            Mensajes.mensajeError("", "Ingrese solo números en el teléfono");
            return false;
        }
        if (inputNumero.getLength() < 10 || inputNumero.getLength() >10) {
            Mensajes.mensajeError("", "El número debe tener 10 dígitos");
            return false;
        }
        return true;
    }
}