package org.example.tgpsi_m19_n15_otacilio_alves1;

import java.time.LocalDate;

public class Transacoes {
    private int idTransacoes;
    private Reserva idReserva;//uma instancia da classe "Reserva" é utilizado como chave estrangeira para representar uma relação
    private LocalDate data_Hora_Transacoes;
    private String tipo_Transacoes;
    private double valor_Transacoes;

    public Transacoes(){
    }

    public Transacoes(int idTransacoes, Reserva idReserva, LocalDate data_Hora_Transacoes, String tipo_Transacoes, double valor_Transacoes) {
        this.idTransacoes = idTransacoes;
        this.idReserva = idReserva;
        this.data_Hora_Transacoes = data_Hora_Transacoes;
        this.tipo_Transacoes = tipo_Transacoes;
        this.valor_Transacoes = valor_Transacoes;
    }

    public int getIdTransacoes() {
        return idTransacoes;
    }

    public void setIdTransacoes(int idTransacoes) {
        this.idTransacoes = idTransacoes;
    }

    public Reserva getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Reserva idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getData_Hora_Transacoes() {
        return data_Hora_Transacoes;
    }

    public void setData_Hora_Transacoes(LocalDate data_Hora_Transacoes) {
        this.data_Hora_Transacoes = data_Hora_Transacoes;
    }

    public String getTipo_Transacoes() {
        return tipo_Transacoes;
    }

    public void setTipo_Transacoes(String tipo_Transacoes) {
        this.tipo_Transacoes = tipo_Transacoes;
    }

    public double getValor_Transacoes() {
        return valor_Transacoes;
    }

    public void setValor_Transacoes(double valor_Transacoes) {
        this.valor_Transacoes = valor_Transacoes;
    }
}
