module com.agenda_contactos {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.agenda_contactos to javafx.fxml;
    exports com.agenda_contactos;
}