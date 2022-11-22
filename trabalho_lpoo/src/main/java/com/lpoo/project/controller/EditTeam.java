package com.lpoo.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lpoo.project.model.Jogador;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EditTeam implements Initializable {

    @FXML
    private TextField time;

    @FXML
    private TextField selecao;

    @FXML
    private NumField grupo;

    @FXML
    private Button submit;

    @FXML
    private Button cancel;

    @FXML
    private URL url;

    @FXML
    private ResourceBundle resources;

    @FXML
    private TableView<Jogador> tblView;

    @FXML
    private TableColumn<Jogador, String> tJogador, tCel, tCPF, tData, tBairro, tCidade, tRua, tCep;

    @FXML
    private TableColumn<Jogador, Integer> tNum, tNumLog;

    @FXML
    private NumField numero, numLog;

    @FXML
    private TextField jogador, cpf, rua, bairro, cidade, cep, data;

    private Time t;

    @FXML
    public void create() {
        String j = jogador.getText(), c = cpf.getText(), r = rua.getText(), b = bairro.getText(), cd = cidade.getText(), cep = cidade.getText(), nlog = numLog.getText(), n = numero.getText(), d = data.getText();

        if(isValid(j) && isValid(c) && isValid(r) && isValid(b) && isValid(cd) && isValid(nlog) && isValid(n) && isValid(d)) {
            // validado as entradas
            if(isValid(cep)) {
                // validado o cep
                new Jogador(j, c, r, b, cd, cep, Integer.parseInt(nlog), n, d, Integer.parseInt(n), t);

            } else {
                // caso nao inserido o cep
               new Jogador(j, c, r, b, cd, Integer.parseInt(nlog), n, d, Integer.parseInt(n), t);
                
            }
            this.attTable();
        }
    }

    private boolean isValid(String a) {
        return a.trim() != "";
    }

    @FXML
    public void editTime() {
        String t = time.getText();
        String s = selecao.getText();
        String g = grupo.getText();

        if(t.trim() != "")
            App.listGroup.get(App.tempI).get(App.tempJ).setNomeTime(t);
        if(s.trim() != "")
            App.listGroup.get(App.tempI).get(App.tempJ).setNomeSelecao(s);
        if(g.trim() != "" && Integer.parseInt(g) > 0 && Integer.parseInt(g) <= App.listGroup.size()) {
            App.listGroup.get(App.tempI).get(App.tempJ).setGrupo(g);
            App.listGroup.get(Integer.parseInt(g) - 1).add(App.listGroup.get(App.tempI).get(App.tempJ));
            App.listGroup.get(App.tempI).rm(App.tempJ);
        }
        Evnts.att();
        this.close();
    }

    public void close() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize(){}

    private void attTable() {

        tblView.getItems().clear();
        
        for(int i = 0; i < t.getListJogadores().size(); i++){
            Jogador j = t.getListJogadores().get(i);
            tblView.getItems().add(null);
            tblView.getItems().set(i, j);
        }
    
    }

    private void initCols() {
        tJogador.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
        tNum.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("num"));
        tCel.setCellValueFactory(new PropertyValueFactory<Jogador, String>("celular"));
        tCPF.setCellValueFactory(new PropertyValueFactory<Jogador, String>("cpf"));
        tData.setCellValueFactory(new PropertyValueFactory<Jogador, String>("dataNascimento"));
        tBairro.setCellValueFactory( data -> new ReadOnlyStringWrapper(data.getValue().getEndereco().getBairro()));
        tCep.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getEndereco().getCep()));
        tCidade.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getEndereco().getCidade()));
        tNumLog.setCellValueFactory(data -> new ReadOnlyIntegerWrapper(data.getValue().getEndereco().getNumero()).asObject());
        tRua.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getEndereco().getRua()));

        this.edtCols();
    }

    private void edtCols() {
        tJogador.setCellFactory(TextFieldTableCell.forTableColumn());
        tNum.setCellFactory(TextFieldTableCell.<Jogador, Integer>forTableColumn(new IntegerStringConverter()));
        tCel.setCellFactory(TextFieldTableCell.forTableColumn());
        tCPF.setCellFactory(TextFieldTableCell.forTableColumn());
        tData.setCellFactory(TextFieldTableCell.forTableColumn());
        tBairro.setCellFactory(TextFieldTableCell.forTableColumn());
        tCep.setCellFactory(TextFieldTableCell.forTableColumn());
        tCidade.setCellFactory(TextFieldTableCell.forTableColumn());
        tNumLog.setCellFactory(TextFieldTableCell.<Jogador, Integer>forTableColumn(new IntegerStringConverter()));
        tRua.setCellFactory(TextFieldTableCell.forTableColumn());
        
        tJogador.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setNome(e.getNewValue()));
        tNum.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setNum(e.getNewValue()));
        tCel.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCelular(e.getNewValue()));
        tCPF.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setCpf(e.getNewValue()));
        tData.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).setDataNascimento(e.getNewValue()));
        tBairro.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).getEndereco().setBairro(e.getNewValue()));
        tCep.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).getEndereco().setCep(e.getNewValue()));
        tCidade.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).getEndereco().setCidade(e.getNewValue()));
        tNumLog.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).getEndereco().setNumero(e.getNewValue()));
        tRua.setOnEditCommit(e->e.getTableView().getItems().get(e.getTablePosition().getRow()).getEndereco().setRua(e.getNewValue()));

        tblView.setEditable(true);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;
        t = App.listGroup.get(App.tempI).get(App.tempJ);
        time.setText(t.getNomeTime());
        selecao.setText(t.getNomeSelecao());
        grupo.setText(Integer.toString(App.tempI + 1));

        initCols();
        attTable();
    }    
}
