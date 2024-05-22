package org.example.tgpsi_m19_n15_otacilio_alves1;

import static org.example.tgpsi_m19_n15_otacilio_alves1.ConfiguraçaoDB.conn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.*;
import java.net.ConnectException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


public class PrincipalController implements Initializable {
    @FXML
    private AnchorPane anchorPaneAcercaDe;
    @FXML
    private Button btnAcercaDe;
    @FXML
    private Button btnAdicionarButtonComputador;
    @FXML
    private Button btnEliminarButtonComputador;
    @FXML
    private Button btnEditarButtonComputador;
    @FXML
    private AnchorPane anchorPaneTransacoes;
    @FXML
    private AnchorPane anchorPaneComputador;
    @FXML
    private TableView TabelaComputador;
    @FXML
    private TableColumn NumPcTabelaComputador;
    @FXML
    private TableColumn NomePcTabelaComputador;
    @FXML
    private TableColumn StatusPcTabelaComputador;
    @FXML
    private TextField txtIdPcButtonComputador;
    @FXML
    private TextField txtNomePcButtonComputador;
    @FXML
    private TextField txtStatusPcButtonComputador;
    @FXML
    private TextField txtSaldoAtualButtonTransacoes;
    @FXML
    private TextField txtQtdDepositarButtonTransacoes;
    @FXML
    private TextField txtTransacaoFeitaButtonTransacoes;
    @FXML
    private Button btnCalcularButtonTransacao;
    @FXML
    private AnchorPane anchorPaneReservaCRUD;
    @FXML
    private AnchorPane anchorPaneReserva;
    @FXML
    private TextField txtIdReservaButtonReserva;
    @FXML
    private TextField txtIdUsuarioButtonReserva;
    @FXML
    private Button btnAdicionarReserva;
    @FXML
    private Button btnEliminarReserva;
    @FXML
    private Button btnEditarReserva;
    @FXML
    private TextField txtNumeroPcButtonReserva;
    @FXML
    private TextField txtHoraInicioButtonReserva;
    @FXML
    private TextField txtHoraTerminoButtonReserva;
    @FXML
    private Button btnTransacoes;
    @FXML
    private Button btnUsuario;
    @FXML
    private Button btnComputador;
    @FXML
    private Button btnReserva;
    @FXML
    private Button btnSair;
    @FXML
    private TextField novoNomeUsuario;
    @FXML
    private AnchorPane anchorPaneUsuario;
    @FXML
    private AnchorPane anchorPaneNovoUsuario;
    @FXML
    private Button btnNewAccount;
    @FXML
    private TableView TabelaReserva;
    @FXML
    private TableColumn IdReserva;
    @FXML
    private TableColumn IdUsuario;
    @FXML
    private TableColumn IdComputador;
    @FXML
    private TableColumn HoraInicioReserva;
    @FXML
    private TableColumn HoraTerminoReserva;
    @FXML
    private TextField senhaUsuario;
    @FXML
    private TextField saldoUsuario;
    @FXML
    private TextField emailUsuario;
    @FXML
    private TextField idUsuario;
    @FXML
    private TextField nomeUsuario;
    @FXML
    private TextField novoSaldoUsuario;
    @FXML
    private TextField novaSenhaUsuario;
    @FXML
    private TextField novoEmailUsuario;

// Botões //
    public void onActionAcercaDe(ActionEvent actionEvent) {
        anchorPaneAcercaDe.setVisible(true);
        anchorPaneReserva.setVisible(false);
        anchorPaneUsuario.setVisible(false);
        anchorPaneNovoUsuario.setVisible(false);
        anchorPaneReservaCRUD.setVisible(false);
        anchorPaneTransacoes.setVisible(false);
        anchorPaneComputador.setVisible(false);
    }
    public void onActionTransacoes(ActionEvent actionEvent) {
        anchorPaneReserva.setVisible(false);
        anchorPaneUsuario.setVisible(false);
        anchorPaneNovoUsuario.setVisible(false);
        anchorPaneReservaCRUD.setVisible(false);
        anchorPaneTransacoes.setVisible(true);
        anchorPaneComputador.setVisible(false);
        anchorPaneAcercaDe.setVisible(false);

    }

    public void onActionUsuario(ActionEvent actionEvent) {
        anchorPaneReserva.setVisible(false);
        anchorPaneUsuario.setVisible(true);
        anchorPaneNovoUsuario.setVisible(true);
        anchorPaneReservaCRUD.setVisible(false);
        anchorPaneTransacoes.setVisible(false);
        anchorPaneComputador.setVisible(false);
        anchorPaneAcercaDe.setVisible(false);

    }

    public void onActionComputador(ActionEvent actionEvent) {
        anchorPaneReserva.setVisible(false);
        anchorPaneUsuario.setVisible(false);
        anchorPaneNovoUsuario.setVisible(false);
        anchorPaneReservaCRUD.setVisible(false);
        anchorPaneTransacoes.setVisible(false);
        anchorPaneComputador.setVisible(true);
        anchorPaneAcercaDe.setVisible(false);

    }

    public void onActionReserva(ActionEvent actionEvent) {
        anchorPaneReserva.setVisible(true);
        anchorPaneUsuario.setVisible(false);
        anchorPaneNovoUsuario.setVisible(false);
        anchorPaneReservaCRUD.setVisible(true);
        anchorPaneTransacoes.setVisible(false);
        anchorPaneComputador.setVisible(false);
        anchorPaneAcercaDe.setVisible(false);

        listReserva();
    }

    public void onActionButtonCalcular(ActionEvent actionEvent) {

    }

    public void onActionSair(ActionEvent actionEvent) {
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


    // Metodos //

    public void onActionCreateNewAccount(ActionEvent actionEvent) {
        conn = ConfiguraçaoDB.abrirBD();
        String sql = "insert into usuario (nome,password, email, saldo) values (?,?,?,?)";
        try {
            PreparedStatement PreparedStatement = conn.prepareStatement(sql);
            PreparedStatement.setString(1, novoNomeUsuario.getText());
            PreparedStatement.setString(2, novoEmailUsuario.getText());
            PreparedStatement.setString(3, novaSenhaUsuario.getText());
            PreparedStatement.setString(4, novoSaldoUsuario.getText());
            PreparedStatement.execute();  } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void listComputador(){
        NumPcTabelaComputador.setCellValueFactory(new PropertyValueFactory<Computador, Integer>("idComputador"));
        NomePcTabelaComputador.setCellValueFactory(new PropertyValueFactory<Computador, String>("nome_Identificador"));
        StatusPcTabelaComputador.setCellValueFactory(new PropertyValueFactory<Computador, String>("Status"));

        TabelaComputador.setItems(ComputadorDAO.listComputador());
    }

    public void listReserva(){
        IdReserva.setCellValueFactory(new PropertyValueFactory<Reserva, Integer>("IdReserva"));
        IdUsuario.setCellValueFactory(new PropertyValueFactory<Reserva, Integer>("IdUsuario"));
        IdComputador.setCellValueFactory(new PropertyValueFactory<Reserva, Integer>("IdComputador"));
        HoraInicioReserva.setCellValueFactory(new PropertyValueFactory<Reserva, LocalDate>("HoraInicioReserva"));
        HoraTerminoReserva.setCellValueFactory(new PropertyValueFactory<Reserva, LocalDate>("HoraTerminoReserva"));

        TabelaReserva.setItems(ReservaDAO.listReserva());

    }

    public void onActionAdicionarReserva(ActionEvent actionEvent) {
        if (txtIdReservaButtonReserva.getText().isEmpty() || txtIdUsuarioButtonReserva.getText().isEmpty() ||
                txtNumeroPcButtonReserva.getText().isEmpty() || txtHoraInicioButtonReserva.getText().isEmpty() ||
                txtHoraTerminoButtonReserva.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos obrigatórios.");
            alert.showAndWait();
            return;
        }

        try {
            // Estabelece uma conexão com a base de dados
            Connection conn = ConfiguraçaoDB.abrirBD();
            if (conn != null) {
                // Obtém os valores dos campos de entrada
                int idReserva = Integer.parseInt(txtIdReservaButtonReserva.getText());
                int idUsuario = Integer.parseInt(txtIdUsuarioButtonReserva.getText());
                int numeroPc = Integer.parseInt(txtNumeroPcButtonReserva.getText());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime dataHoraInicio = LocalDateTime.parse(txtHoraInicioButtonReserva.getText(), formatter);
                LocalDateTime dataHoraTermino = LocalDateTime.parse(txtHoraTerminoButtonReserva.getText(), formatter);

                // Cria e mostra uma caixa de confirmação antes de adicionar a reserva
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText("Deseja realmente adicionar esta reserva?");
                alert.setContentText("ID da Reserva: " + idReserva + "\nID do Usuário: " + idUsuario +
                        "\nNúmero do PC: " + numeroPc + "\nData/Hora Início: " + dataHoraInicio +
                        "\nData/Hora Término: " + dataHoraTermino);
                ButtonType btnSim = new ButtonType("SIM");
                ButtonType btnNao = new ButtonType("NÃO");
                alert.getButtonTypes().setAll(btnSim, btnNao);

                // Se o utilizador confirmar a adição da reserva
                alert.showAndWait().ifPresent(Btn -> {
                    if (Btn == btnSim) {
                        try {
                            // Prepara a instrução SQL para inserir uma nova reserva
                            String sql = "INSERT INTO Reserva (ID, ID_Usuario, ID_Computador, Data_Hora_Inicio, Data_Hora_Termino) VALUES (?, ?, ?, ?, ?)";
                            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                            stmt.setInt(1, idReserva);
                            stmt.setInt(2, idUsuario);
                            stmt.setInt(3, numeroPc);
                            stmt.setTimestamp(4, Timestamp.valueOf(dataHoraInicio));
                            stmt.setTimestamp(5, Timestamp.valueOf(dataHoraTermino));
                            stmt.executeUpdate();

                            // Obtém o ID gerado para a nova reserva
                            int gerarID = -1;
                            ResultSet gerarKey = stmt.getGeneratedKeys();
                            if (gerarKey.next()) {
                                gerarID = gerarKey.getInt(1);
                            }

                            // Mostra uma mensagem de sucesso após adicionar a reserva
                            Alert alertAddReserva = new Alert(Alert.AlertType.INFORMATION);
                            alertAddReserva.setTitle("Informação");
                            alertAddReserva.setHeaderText("Reserva adicionada com sucesso");
                            alertAddReserva.setContentText(null);
                            alertAddReserva.showAndWait();

                            // Limpa os campos de entrada após a adição
                            txtIdReservaButtonReserva.clear();
                            txtIdUsuarioButtonReserva.clear();
                            txtNumeroPcButtonReserva.clear();
                            txtHoraInicioButtonReserva.clear();
                            txtHoraTerminoButtonReserva.clear();

                        } catch (SQLException e) {
                            // Mostra uma mensagem de erro em caso de exceção SQL
                            Alert alertErro = new Alert(Alert.AlertType.ERROR);
                            alertErro.setTitle("ERRO");
                            alertErro.setHeaderText("Erro ao adicionar a reserva: " + e.getMessage());
                            alertErro.showAndWait();
                        }
                    }
                });
            } else {
                // Mostra uma mensagem de erro se não for possível estabelecer a conexão com a base de dados
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Não foi possível estabelecer uma conexão com a base de dados");
                alert.setContentText(null);
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            // Mostra uma mensagem de erro se os dados de entrada não estiverem no formato correto
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText("Coloque os respetivos dados de acordo com o formato.");
            alert.showAndWait();
        } finally {
            // Fecha a conexão com a base de dados
            ConfiguraçaoDB.fecharBD();
        }
    }

    public void onActionEliminarReserva(ActionEvent actionEvent) {

    }

    public void onActionEditarReserva(ActionEvent actionEvent) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listComputador();
    }

    public void onActionAdicionarComputador(ActionEvent actionEvent) {
        if(txtNomePcButtonComputador.getText().isEmpty() || txtStatusPcButtonComputador.getText().isEmpty()){
            // Cria e mostra uma mensagem de erro se algum campo estiver vazio
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERRO");
            alert.setHeaderText(null);
            alert.setContentText("por favor preencha todos os espaços");
            alert.showAndWait();
        } else {
            try {
                // Estabelece uma conexão com a base de dados
                Connection conn = ConfiguraçaoDB.abrirBD();
                if(conn != null){
                    /// Obtém os valores dos campos de entrada
                    String nome_Identificador = String.valueOf(txtNomePcButtonComputador.getText());
                    String Status = String.valueOf(txtStatusPcButtonComputador.getText());

                    // Cria e mostra uma caixa de confirmação antes de adicionar o quarto
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Coonfirmação");
                    alert.setHeaderText("Deseja realmente adicionar?");
                    alert.setContentText("Nome do PC: "+ nome_Identificador +"\nStatus do PC: " + Status);
                    ButtonType btnSim = new ButtonType("SIM");
                    ButtonType btnNao = new ButtonType("NÃO");
                    alert.getButtonTypes().setAll(btnSim, btnNao);

                    // Se o utilizador confirmar a adição do quarto
                    alert.showAndWait().ifPresent(Btn -> {
                        if (Btn == btnSim) {
                            try {
                                // Prepara a instrução SQL para inserir um novo PC
                                String sql = "INSERT INTO Computador(Nome_Identificador, Status) VALUES (?,?)";
                                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                                stmt.setString(1, nome_Identificador);
                                stmt.setString(2, Status);
                                stmt.executeUpdate();

                                // Obtém o ID gerado para o novo PC
                                int gerarID = -1;
                                ResultSet gerarKey = stmt.getGeneratedKeys();
                                if (gerarKey.next()) {
                                    gerarID = gerarKey.getInt(1);
                                }


                                // Mostra uma mensagem de sucesso após adicionar o PC
                                Alert alertAddQuarto = new Alert(Alert.AlertType.INFORMATION);
                                alertAddQuarto.setTitle("Informação");
                                alertAddQuarto.setHeaderText("PC adicionado com sucesso");
                                alertAddQuarto.setContentText(null);
                                alertAddQuarto.showAndWait();

                                // Adiciona o novo PC à tabela de visualização
                                Computador computador = new Computador(gerarID, nome_Identificador, Status);
                                TabelaComputador.getItems().add(computador);

                                // Limpa os campos de entrada após a adição
                                txtNomePcButtonComputador.clear();
                                txtStatusPcButtonComputador.clear();

                            } catch (SQLException e) {
                                // Mostra uma mensagem de erro em caso de exceção SQL
                                Alert alertErro = new Alert(Alert.AlertType.ERROR);
                                alertErro.setTitle("ERRO");
                                alertErro.setHeaderText("Erro ao adicionar o Quarto: " + e.getMessage());
                                alertErro.showAndWait();
                            }
                        }

                    });
                } else {
                    // Mostra uma mensagem de erro se não for possível estabelecer a conexão com a base de dados
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText("Nao foi possivel estabelecer uma conexão com a base de dados");
                    alert.setContentText(null);
                    alert.showAndWait();
                }
            }catch (NumberFormatException e){
                // Mostra uma mensagem de erro se os dados de entrada não estiverem no formato correto
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Coloque os respetivos dados de acordo com o formato.");
                alert.showAndWait();
            }finally {
                //Fecha a conexão com a base de dados
                ConfiguraçaoDB.fecharBD();
            }
        }
    }

    public void onActionEliminarComputador(ActionEvent actionEvent) {
        // Verifica se algum dos campos obrigatórios está vazio
        Computador selectedComputador = (Computador) TabelaComputador.getSelectionModel().getSelectedItem();
        if (selectedComputador == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um computador para eliminar.");
            alert.showAndWait();
            return;
        }

        // Confirma a eliminação
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(null);
        alert.setContentText("Tem certeza que deseja eliminar o computador selecionado?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Executa a eliminação do computador
                try (Connection conn = ConfiguraçaoDB.abrirBD()) {
                    String sql = "DELETE FROM Computador WHERE ID = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, selectedComputador.getIdComputador());
                        stmt.executeUpdate();

                        // Remove o computador da tabela visual
                        TabelaComputador.getItems().remove(selectedComputador);

                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Sucesso");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText("Computador eliminado com sucesso.");
                        successAlert.showAndWait();
                    }
                } catch (SQLException e) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Erro");
                    errorAlert.setHeaderText("Erro ao eliminar o computador.");
                    errorAlert.setContentText(e.getMessage());
                    errorAlert.showAndWait();
                }
            }
        });
    }

    public void onActionEditarComputador(ActionEvent actionEvent) {
// Verifica se algum dos campos obrigatórios está vazio
        Computador selectedComputador = (Computador) TabelaComputador.getSelectionModel().getSelectedItem();
        if (selectedComputador == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecione um computador para editar.");
            alert.showAndWait();
            return;
        }

        // Obter os valores dos campos de texto
        String novoNome = txtNomePcButtonComputador.getText();
        String novoStatus = txtStatusPcButtonComputador.getText();

        if (novoNome.isEmpty() || novoStatus.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, preencha todos os campos.");
            alert.showAndWait();
            return;
        }

        // Confirma a edição
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(null);
        alert.setContentText("Tem certeza que deseja editar o computador selecionado?");
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Executa a edição do computador
                try (Connection conn = ConfiguraçaoDB.abrirBD()) {
                    String sql = "UPDATE Computador SET Nome_Identificador = ?, Status = ? WHERE ID = ?";
                    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setString(1, novoNome);
                        stmt.setString(2, novoStatus);
                        stmt.setInt(3, selectedComputador.getIdComputador());
                        stmt.executeUpdate();

                        // Atualiza os valores no objeto Computador e na tabela visual
                        selectedComputador.setNome_Identificador(novoNome);
                        selectedComputador.setStatus(novoStatus);
                        TabelaComputador.refresh();

                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Sucesso");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText("Computador editado com sucesso.");
                        successAlert.showAndWait();
                    }
                } catch (SQLException e) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Erro");
                    errorAlert.setHeaderText("Erro ao editar o computador.");
                    errorAlert.setContentText(e.getMessage());
                    errorAlert.showAndWait();
                }
            }
        });
    }
}