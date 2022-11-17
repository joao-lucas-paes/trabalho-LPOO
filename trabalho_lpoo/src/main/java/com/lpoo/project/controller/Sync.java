package com.lpoo.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Sync implements Initializable {

    @FXML
    private URL url;

    @FXML
    private ResourceBundle resources;

    @FXML
    private Button cancel;

    @FXML
    private NumField grupo;

    @FXML
    private ChoiceBox<String> time;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;

        String values[] = new String[App.UnsignedTeam.size()];

        for(int i = 0; i < App.UnsignedTeam.size(); i++)
            values[i] = App.UnsignedTeam.get(i).getNomeTime();
        
        time.setItems( FXCollections.observableArrayList(values));
    }

    @FXML
    private void initialize(){}

    // verifica e sincroniza
    @FXML
    public void create(){
        try {
            int num = Integer.parseInt(grupo.getText()); // tenta transformar o numField em um numero
            int unTime = time.getSelectionModel().getSelectedIndex(); // da get do valor do time
            
            if(num > 0 && num <= App.listGroup.size() && unTime != -1) {
                Time copy = App.UnsignedTeam.get(unTime); // recebe o valor do time
                App.UnsignedTeam.remove(unTime); // retira ele da classificacao unsigned
                App.listGroup.get(num - 1).add(copy); // adiciona no grupo
            }
            
            Evnts.att();
            this.close();
        } catch (Exception e) {}
    }
    
    // fecha o popup
    public void close(){
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
