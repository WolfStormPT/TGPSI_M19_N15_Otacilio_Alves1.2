module org.example.tgpsi_m19_n15_otacilio_alves1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires java.desktop;
    requires jdk.jdi;


    opens org.example.tgpsi_m19_n15_otacilio_alves1 to javafx.fxml;
    exports org.example.tgpsi_m19_n15_otacilio_alves1;
}