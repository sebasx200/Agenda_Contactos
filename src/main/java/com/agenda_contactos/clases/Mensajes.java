package com.agenda_contactos.clases;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class Mensajes {

    // método para mostrarle al usuario un mensaje informativo
    public static void mensajeInformativo(String header, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setContentText(mensaje);
        alerta.setHeaderText(header);
        alerta.showAndWait();
    }

    public static void mensajeAdvertencia(String header, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Advertencia");
        alerta.setContentText(mensaje);
        alerta.setHeaderText(header);
        alerta.showAndWait();
    }

    public static void mensajeError(String header, String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setContentText(mensaje);
        alerta.setHeaderText(header);
        alerta.showAndWait();
    }
    public static boolean mensajeConfirmacion(String titulo, String header, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

        alerta.setGraphic(null);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.setHeaderText(header);

        ButtonType botonConfirmar = new ButtonType("Confirmar");
        ButtonType botonCancelar = new ButtonType("Cancelar");
        alerta.getButtonTypes().setAll(botonConfirmar, botonCancelar);
        Optional<ButtonType> resultado = alerta.showAndWait();
        return resultado.filter(response -> response == botonConfirmar).isPresent();
    }

}
