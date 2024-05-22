package org.example.tgpsi_m19_n15_otacilio_alves1;

import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
    public static ObservableList<Reserva> listReserva() {
        Connection conn = ConfiguraçaoDB.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<Reserva> reservas = Settings.getListReserva();
        String sql = "SELECT * FROM Reserva;";

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                int ID_Usuario = rs.getInt("ID_Usuario");
                int ID_Computador = rs.getInt("ID_Computador");
                LocalDate Data_Hora_Inicio = rs.getDate("Data_Hora_Inicio").toLocalDate();
                LocalDate Data_Hora_Termino = rs.getDate("Data_Hora_Termino").toLocalDate();
                Reserva r = new Reserva(ID, ID_Usuario,ID_Computador, Data_Hora_Inicio, Data_Hora_Termino);
                reservas.add(r);
            }
        }
        catch (SQLException ex){
            System.out.println("Erro ao listar as reservas" + ex);
        }finally {
            ConfiguraçaoDB.fecharBD(stmt, rs);
        }
        return reservas;
    }
}
