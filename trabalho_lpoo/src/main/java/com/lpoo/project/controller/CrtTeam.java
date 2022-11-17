package com.lpoo.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;

public class CrtTeam implements Initializable {

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

    public CrtTeam(){}

    @FXML
    private void initialize(){}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;
    }

    @FXML
    public void create() {
        String time = this.time.getText();
        String selecao = this.selecao.getText();
        String numGrupo = this.grupo.getText();
        if(isValid(time) && isValid(selecao)) {
            if(numGrupo == "" || isValid(Integer.parseInt(numGrupo))) {
                if(numGrupo == "")
                    App.UnsignedTeam.add(new Time(time, selecao, "N/A"));
                else {
                    App.listGroup.get(Integer.parseInt(numGrupo) - 1).add(new Time(time, selecao, "N/A"));
                    Evnts.att();
                }
                this.close();
            }
        }
    }

    private boolean isValid(String arg0) {
        return arg0 != null && !arg0.trim().equals("");
    }

    private boolean isValid(int arg0) {
        return arg0 > 0 && arg0 <= App.listGroup.size();
    }

    public void close() {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }
}
