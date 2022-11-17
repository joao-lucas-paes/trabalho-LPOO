package com.lpoo.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lpoo.project.model.Grupo;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;

import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

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

    static GridPane gp;

    static void att() {
        for(int i = 0; i < App.listGroup.size(); i++) {
            GridPane child = (GridPane) gp.getChildren().get(i + 3);
            child.getChildren().clear();
            App.listGroup.get(i).sort();

            gInto(child);
            
            for(int j = 0; j < App.listGroup.get(i).length(); j++) {
                Label[] toFill = App.listGroup.get(i).generateSpecifyAttr(j);

                for(int k = 0; k < toFill.length; k++) {
                    GridPane.setColumnIndex(toFill[k], k);
                    GridPane.setRowIndex(toFill[k], j + 1);
                    child.getChildren().add(toFill[k]);
                }
                GridPane grid = new GridPane();
                Button btn = new Button("...");
                Button btnRm = new Button("x");

                btnRm.setId(i + "-" + j);

                GridPane.setColumnIndex(btn, 0);
                GridPane.setRowIndex(btn, 0);

                grid.getChildren().add(btn);

                GridPane.setColumnIndex(btnRm, 1);
                GridPane.setRowIndex(btnRm, 0);

                grid.getChildren().add(btnRm);

                GridPane.setColumnIndex(grid, toFill.length);
                GridPane.setRowIndex(grid, j + 1);

                child.getChildren().add(grid);
                
                javafx.event.EventHandler<ActionEvent> event = new javafx.event.EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        try {
                            App.loadFXML("");
                        } catch (IOException e1) {
                           
                            e1.printStackTrace();
                        }
                    }
                };
                javafx.event.EventHandler<ActionEvent> rm = new javafx.event.EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e) {
                        String arr[] = ((Button) e.getTarget()).getId().split("-");
                        int i = Integer.parseInt(arr[0]);
                        int j = Integer.parseInt(arr[1]);
                        App.listGroup.get(i).rm(j);
                        Evnts.att();
                    }
                };

                btn.setOnAction(event);
                btnRm.setOnAction(rm);
            }
        }
    }

    @FXML
    public void btnCreate() {
        GridPane tView = createTbl();
        
        GridPane.setColumnIndex(tView, col);
        GridPane.setRowIndex(tView, lin);

        this.screen.getChildren().add(tView);

        this.col++;
        if(this.col > 2){
            this.lin++; 
            this.col = 0;
        }

        App.listGroup.add(new Grupo(new ArrayList<Time>()));
    }

    static private GridPane createTbl() {
        GridPane tableView = new GridPane();

        tableView.getStyleClass().add("group");

        gInto(tableView);

        return tableView;
    }

    static private void gInto(GridPane tableView) {
        Node[] l = {new Label(" Time "), new Label(" Seleção "), new Label(" P "), new Label(" J "), new Label(" D "), new Label(" E "), new Label(" Visualizar Time / Editar ")};

        for(int i = 0; i < l.length; i++) {
            GridPane.setColumnIndex(l[i], i);
            GridPane.setRowIndex(l[i], 0);

            l[i].getStyleClass().add("item");

            tableView.getChildren().add(l[i]);
        }
    } 

    @FXML
    public void btnCreateTeam() {
        this.open("createTime");
    }

    @FXML
    public void btnSync() {
        this.open("toSync");
    }

    public void open(String value) {
        Dialog dialog = new Dialog<Object>();
        
        try {
            dialog.setGraphic(App.loadFXML(value));
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.show();
    }

    public Evnts(){}

    @FXML
    private void initialize(){}

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        this.url = arg0;
        this.resources = arg1;
        Evnts.gp = this.screen;
    }

}
