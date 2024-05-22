package org.example.tgpsi_m19_n15_otacilio_alves1;

import java.time.LocalDate;

public class Reserva {
    private int idResrva;
    private int idUsuario;
    private int idComputador;
    private LocalDate data_Hora_Inicio;
    private LocalDate data_Hora_Termino;

    public Reserva() {

    }

    public Reserva(int idResrva, int idUsuario, int idComputador, LocalDate data_Hora_Inicio, LocalDate data_Hora_Termino) {
        this.idComputador = idComputador;
        this.idUsuario = idUsuario;
        this.data_Hora_Inicio = data_Hora_Inicio;
        this.data_Hora_Termino = data_Hora_Termino;
        this.idResrva = idResrva;

    }

    public Reserva(int newId, int newIdReserva, int newIdUsuario, int newIdPc, String newHoraInicio, String newHoraTermino) {

    }

    public int getIdResrva() {
        return idResrva;
    }

    public void setIdResrva(int idResrva) {
        this.idResrva = idResrva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public LocalDate getData_Hora_Inicio() {
        return data_Hora_Inicio;
    }

    public void setData_Hora_Inicio(LocalDate data_Hora_Inicio) {
        this.data_Hora_Inicio = data_Hora_Inicio;
    }

    public LocalDate getData_Hora_Termino() {
        return data_Hora_Termino;
    }

    public void setData_Hora_Termino(LocalDate data_Hora_Termino) {
        this.data_Hora_Termino = data_Hora_Termino;
    }
}


