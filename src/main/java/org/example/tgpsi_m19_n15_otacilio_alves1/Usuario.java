package org.example.tgpsi_m19_n15_otacilio_alves1;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String password;
    private double saldo;

    public Usuario(){
    }

    public Usuario(int idUsuario, String nome, String email, String password, double saldo){
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.saldo = saldo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
