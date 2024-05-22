package org.example.tgpsi_m19_n15_otacilio_alves1;

import javafx.scene.control.TableColumn;

public class Computador {
    private int idComputador;
    private String nome_Identificador;
    private String Status;

    public Computador(){
    }

    public Computador(int idComputador, String nome_Identificador, String Status){
        this.idComputador = idComputador;
        this.nome_Identificador = nome_Identificador;
        this.Status = Status;
    }

    public int getIdComputador() {
        return idComputador;
    }

    public void setIdComputador(int idComputador) {
        this.idComputador = idComputador;
    }

    public String getNome_Identificador() {
        return nome_Identificador;
    }

    public void setNome_Identificador(String nome_Identificador) {
        this.nome_Identificador = nome_Identificador;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
