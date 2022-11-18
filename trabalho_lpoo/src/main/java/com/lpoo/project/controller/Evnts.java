package com.lpoo.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lpoo.project.model.Grupo;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

    /**
     * Essa funcao atualiza a interface dos grupos e adiciona os botoes e os eventos para cada um
     */
    static void att() {
        for(int i = 0; i < App.listGroup.size(); i++) {
            GridPane child = (GridPane) gp.getChildren().get(i + 3);
            child.getChildren().clear();
            App.listGroup.get(i).sort();

            gInto(child);
            
            for(int j = 0; j < App.listGroup.get(i).length(); j++) {
                Label[] toFill = App.listGroup.get(i).generateSpecifyAttr(j); // da get nas labels

                for(int k = 0; k < toFill.length; k++) {
                    GridPane.setColumnIndex(toFill[k], k); // arruma o index da coluna
                    GridPane.setRowIndex(toFill[k], j + 1); // arruma o index da linha
                    child.getChildren().add(toFill[k]); // adiciona as labels
                }
                GridPane grid = new GridPane(); // grid para que os botoes fiquem no mesmo espaco
                Button btn = new Button("..."); // botao de utilidades
                Button btnRm = new Button("x"); // botao para remover

                btn.setId(i + "-" + j);
                btnRm.setId(i + "-" + j); // setta o id baseado na posicao dele no arraylist global

                GridPane.setColumnIndex(btn, 0); // setta o index correto da coluna para o btn
                GridPane.setRowIndex(btn, 0); // setta o index correto da linha para o btn

                grid.getChildren().add(btn); // adiciona o botao na interface

                GridPane.setColumnIndex(btnRm, 1); // setta o index correto da coluna para o btnRm
                GridPane.setRowIndex(btnRm, 0); // setta o index correto da coluna para o btnRm

                grid.getChildren().add(btnRm); // adiciona o botao de remover na interface

                // mesmo processo descrito acima
                GridPane.setColumnIndex(grid, toFill.length);
                GridPane.setRowIndex(grid, j + 1);

                child.getChildren().add(grid);
                
                // cria uma classe anonymous inner type para o evento de clique para abri as utilidades 
                javafx.event.EventHandler<ActionEvent> event = new javafx.event.EventHandler<ActionEvent>() {
                    public void handle(ActionEvent e) {
                        try {
                            Dialog<EditTeam> dialog = new Dialog<EditTeam>();


                            String arr[] = ((Button) e.getTarget()).getId().split("-"); // obtem o i e o j colocado no id 
                            int i = Integer.parseInt(arr[0]); // transforma em inteiros
                            int j = Integer.parseInt(arr[1]); // mesma coisa da linha acima
                            App.tempI = i;
                            App.tempJ = j;
                            
                            dialog.setGraphic(App.loadFXML("editTeam"));

                            dialog.showAndWait();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                };
                // cria uma classe anonymous inner type para o evento de clique para remover a selecao
                javafx.event.EventHandler<ActionEvent> rm = new javafx.event.EventHandler<ActionEvent>() {

                    public void handle(ActionEvent e) {
                        String arr[] = ((Button) e.getTarget()).getId().split("-"); // obtem o i e o j colocado no id 
                        int i = Integer.parseInt(arr[0]); // transforma em inteiros
                        int j = Integer.parseInt(arr[1]); // mesma coisa da linha acima
                        App.listGroup.get(i).rm(j); // remove do grupo
                        Evnts.att(); // atualiza a GUI
                    }
                };

                // setta os eventos
                btn.setOnAction(event); 
                btnRm.setOnAction(rm);
            }
        }
    }

    // essa funcao cria as tabelas e limita 3 por linha
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

    // gera o gridPane
    static private GridPane createTbl() {
        GridPane tableView = new GridPane();

        tableView.getStyleClass().add("group");

        gInto(tableView);

        return tableView;
    }

    // insere o topo da tabela "grupo" dentro de um gridPane
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
        open("createTime");
    }

    @FXML
    public void btnSync() {
        open("toSync");
    }

    // cria popups baseados no "value" abrindo um FXML
    public static void open(String value) {
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
        Evnts.gp = this.screen; // faz uma referencia "global" à screen
    }

}
