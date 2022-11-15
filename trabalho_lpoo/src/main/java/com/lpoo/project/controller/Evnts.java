package com.lpoo.project.controller;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Evnts implements Initializable {
    @FXML 
    private Button primaryButton;
    
    @FXML 
    private GridPane screen;

    @FXML
    private URL url;

    @FXML
    private ResourceBundle resources;

    private int col = 0, lin = 1;

    @FXML
    public void btnCreate() {
        GridPane tView = this.createTbl();
        
        GridPane.setColumnIndex(tView, col);
        GridPane.setRowIndex(tView, lin);

        this.screen.getChildren().add(tView);

        this.col++;
        if(this.col > 2){
            this.lin++; 
            this.col = 0;
        }
    }

    private GridPane createTbl() {
        GridPane tableView = new GridPane();

        tableView.getStyleClass().add("group");

        Node[] l = {new Label(" Time "), new Label(" Seleção "), new Label(" P "), new Label(" J "), new Label(" D "), new Label(" E "), new Label(" Visualizar Time / Editar ")};

        for(int i = 0; i < l.length; i++) {
            GridPane.setColumnIndex(l[i], i);
            GridPane.setRowIndex(l[i], 0);

            l[i].getStyleClass().add("item");

            tableView.getChildren().add(l[i]);
        }

        return tableView;
    }

    public Evnts(){}

    @FXML
    private void initialize(){}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;
    }

}
