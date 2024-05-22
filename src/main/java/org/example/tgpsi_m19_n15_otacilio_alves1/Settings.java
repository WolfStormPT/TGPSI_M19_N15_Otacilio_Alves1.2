package org.example.tgpsi_m19_n15_otacilio_alves1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Settings {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Settings.primaryStage = primaryStage;
    }


    private static Computador ComputadortEdit;

    public static Computador getComputadortEdit() {
        return ComputadortEdit;
    }

    public static void setComputadortEdit(Computador ComputadorEdit) {
        Settings.ComputadortEdit = ComputadortEdit;
    }

    public static ObservableList<Computador> listComputador = FXCollections.observableArrayList();

    public static ObservableList<Computador> getListComputador() {
        return listComputador;
    }

    public static void setlistComputador(ObservableList<Computador> listComputador) {
        Settings.listComputador = listComputador;
    }


    //------------------------------------------------------------------------
    private static Reserva ReservaEdit;

    public static Reserva getReservaEdit() {
        return ReservaEdit;
    }

    public static void setReservaEdit(Reserva ReservaEdit) {
        Settings.ReservaEdit = ReservaEdit;
    }

    public static ObservableList<Reserva> listReserva = FXCollections.observableArrayList();

    public static ObservableList<Reserva> getListReserva() {
        return listReserva;
    }

    public static void setListReserva(ObservableList<Reserva> listReserva) {
        Settings.listReserva = listReserva;
    }
}
