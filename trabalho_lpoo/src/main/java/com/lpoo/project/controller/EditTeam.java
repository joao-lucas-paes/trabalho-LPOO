package com.lpoo.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lpoo.project.model.Jogador;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private TableView tblView;

    public EditTeam(){}

    @FXML
    public void create() {
        
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;
        Time t = App.listGroup.get(App.tempI).get(App.tempJ);
        time.setText(t.getNomeTime());
        selecao.setText(t.getNomeSelecao());
        grupo.setText(Integer.toString(App.tempI + 1));

        for(int i = 0; i < t.getListJogadores().size(); i++) {
            Jogador j = t.getListJogadores().get(i);
            TextField[] jogadores = {
                new TextField(j.getNome()),
                new TextField(j.getCelular()),
                new TextField(j.getCelular()),
                new TextField(j.getEndereco().toString()),
            };
            tblView.getColumns().addAll(jogadores);
        }
    }    
}
