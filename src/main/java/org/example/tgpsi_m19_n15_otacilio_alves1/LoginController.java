package org.example.tgpsi_m19_n15_otacilio_alves1;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class LoginController {
    @FXML
    private TextField txt_Name;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private Label labelMensagem;
    @FXML
    private AnchorPane Login;
    @FXML
    private Button btnSair;
    @FXML
    private Button btnLogin;
    @FXML
    private Button Cancelar;

    Connection conn = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;


    public void button_Cancelar_On_Action(ActionEvent actionEvent) {

    }

    public void button_Sair_On_Action(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sair da aplicação");
        alert.setHeaderText("Deseja mesmo sair da apliação?");
        // Adiciona botões personalizados em português
        ButtonType botaoSim = new ButtonType("Sim");
        ButtonType botaoNao = new ButtonType("Não");
        alert.getButtonTypes().setAll(botaoSim, botaoNao);

        alert.showAndWait().ifPresent(response -> {
            if (response == botaoSim) {
                Stage stage = (Stage) btnSair.getScene().getWindow();
                stage.close();
            }
        });
    }

    public void button_Login_On_Action(ActionEvent actionEvent) {
        conn = ConfiguraçaoDB.abrirBD();
        String sql = " Select * from Usuario where Nome= ? and senha = ?";
        try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,txt_Name.getText());
            preparedStatement.setString(2,txt_Password.getText());
            resultSet = preparedStatement.executeQuery();


            if(resultSet.next()){
                btnLogin.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Principal.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }


        }catch (Exception e){

        }
    }

}
