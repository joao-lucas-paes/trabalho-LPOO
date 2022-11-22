package com.lpoo.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GetCpf implements Initializable {
    static public String results = ""; 

    @FXML
    private TextField cpf;

    public GetCpf() {}

    @FXML
    private void initialize(){}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {}

    @FXML
    public void newCpfInserted() {
        Stage stage = (Stage) cpf.getScene().getWindow();
        GetCpf.results = cpf.getText();
        stage.close();
    }
    
}
