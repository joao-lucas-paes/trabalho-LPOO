package com.lpoo.project.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.lpoo.project.model.Endereco;
import com.lpoo.project.model.Jogador;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private TableColumn<Jogador, String> tJogador, tCel, tCPF, tEnd, tData;

    @FXML
    private TableColumn<Jogador, Integer> tNum, tNumLog;

    @FXML
    private NumField numero, numLog;

    @FXML
    private TextField jogador, cpf, rua, bairro, cidade, cep, data;

    @FXML
    private TableColumn<Jogador, Button> updt;

    private Time t;

    @FXML
    public void create() {
        String j = jogador.getText(), c = cpf.getText(), r = rua.getText(), b = bairro.getText(), cd = cidade.getText(), cep = cidade.getText(), nlog = numLog.getText(), n = numero.getText(), d = data.getText();
        if(isValid(j) && isValid(c) && isValid(r) && isValid(b) && isValid(cd) && isValid(nlog) && isValid(n) && isValid(d)) {
            // validado as entradas
            if(isValid(cep)) {
                // validado o cep
                List<Jogador> a = App.listGroup.get(App.tempI).get(App.tempJ).getListJogadores();
                a.add(new Jogador(j, c, r, b, cd, cep, Integer.parseInt(nlog), n, d, Integer.parseInt(n), t, new Button("atualizar dados")));
                App.listGroup.get(App.tempI).get(App.tempJ).setListJogadores(a);
            } else {
                // caso nao inserido o cep
                List<Jogador> a = App.listGroup.get(App.tempI).get(App.tempJ).getListJogadores();
                a.add(new Jogador(j, c, r, b, cd, Integer.parseInt(nlog), n,  d, Integer.parseInt(n), t, new Button("atualizar dados")));
                App.listGroup.get(App.tempI).get(App.tempJ).setListJogadores(a);
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
        ObservableList<Jogador> dataTable = FXCollections.observableArrayList();
        
        for(int i = 0; i < t.getListJogadores().size(); i++)
            dataTable.add(t.getListJogadores().get(i));
        
        tblView.setItems(dataTable);
    }

    private void initCols() {
        tJogador.setCellValueFactory(new PropertyValueFactory<Jogador, String>("nome"));
        tNum.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("num"));
        tEnd.setCellValueFactory(new PropertyValueFactory<Jogador, String>("endereco"));
        tCel.setCellValueFactory(new PropertyValueFactory<Jogador, String>("celular"));
        tCPF.setCellValueFactory(new PropertyValueFactory<Jogador, String>("cpf"));
        tData.setCellValueFactory(new PropertyValueFactory<Jogador, String>("dataNascimento"));
        updt.setCellValueFactory(new PropertyValueFactory<Jogador, Button>("updt"));
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
