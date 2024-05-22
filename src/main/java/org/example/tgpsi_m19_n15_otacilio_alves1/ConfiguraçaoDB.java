package org.example.tgpsi_m19_n15_otacilio_alves1;

import java.sql.*;

public class ConfiguraçaoDB {
    private static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:mysql://localhost:3306/lanhouse";
    static Connection conn = null;

    public static Connection abrirBD() {
        //Driver do MySQL
        try {
            Class.forName(driverJDBC);
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Ligação à base de dados...OK");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro na ligação à base de dados!!!: " + ex);
        }
        return conn;
    }



    public static void fecharBD() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a Ligação à base de dados: " + ex);
        }
    }

    public static void fecharBD(Statement stmt) {
        fecharBD();
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a Ligação à base de dados: " + ex);
        }
    }

    public static void fecharBD(Statement stmt, ResultSet resulset) {
        fecharBD(stmt);
        try {
            if (resulset != null) {
                resulset.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a Ligação à base de dados: " + ex);
        }
    }
}
