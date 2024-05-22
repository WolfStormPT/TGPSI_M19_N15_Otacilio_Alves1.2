package org.example.tgpsi_m19_n15_otacilio_alves1;

import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComputadorDAO {
    public static ObservableList<Computador> listComputador() {
        Connection conn = ConfiguraçaoDB.abrirBD();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ObservableList<Computador> computador = Settings.getListComputador();
        String sql = "Select * From Computador;";

        try {
            // Use a classe correta java.sql.Connection
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idComputador = rs.getInt("ID");
                String nome_Identificador = rs.getString("Nome_Identificador"); // Corrigido o nome para seguir a convenção camelCase
                String Status = rs.getString("Status"); // Corrigido o nome para seguir a convenção camelCase
                Computador c = new Computador(idComputador, nome_Identificador, Status);
                computador.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao listar o Computador: " + ex);
        } finally {
            ConfiguraçaoDB.fecharBD(stmt, rs);
        }
        return computador;
    }
}