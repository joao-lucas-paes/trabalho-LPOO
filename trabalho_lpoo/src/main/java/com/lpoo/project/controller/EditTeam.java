package com.lpoo.project.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.lpoo.project.model.Jogador;
import com.lpoo.project.model.Jogos;
import com.lpoo.project.model.Time;
import com.lpoo.project.view.App;
import com.lpoo.project.view.NumField;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EditTeam implements Initializable {

    @FXML
    private ChoiceBox<Time> time2;

    @FXML
    private TableColumn<Jogos, String> txt, tLocal, tg1, tg2, qtdg1, qtdg2;

    @FXML
    private TableColumn<Jogos, Time> tTime1, tTime2;

    @FXML
    private TextField local, gtime1, gtime2;

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
    private TableView<Jogos> tblViewJogos;

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

    private static Time t;

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

    @FXML
    public void createMatch() {
        String l = local.getText(), g1 = gtime1.getText(), g2 = gtime2.getText();
        if(isValid(l) && ((isArrInt(g1) || g1.trim() == "") && (isArrInt(g2) && g2.trim() == ""))) {
            int[] arr1 = getArrInt(g1), arr2 = getArrInt(g2);
            Time t2 = time2.getValue();
            Jogador j1[] = t.get(arr1), j2[] = t2.get(arr2);
            ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
            
            for(var j: j1) {
                jogadores.add(j);
            }
            for(var j: j2) {
                jogadores.add(j);
            }

            App.matchs.add(new Jogos( t.getNomeTime() + "x" + t2.getNomeTime(), j1.length, j2.length, jogadores, l));

        }

    }

    int[] getArrInt(String arg01) {
        if(arg01.trim() == "")
            return new int[0];
        String arr[] = arg01.split(" ");
        int toReturn[] = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            toReturn[i] = Integer.parseInt(arg01);
        }

        return toReturn;
    }

    boolean isArrInt(String arg01) {
        String arr[] = arg01.split(" ");
        for(int i = 0; i < arr.length; i++) {
            try {
                Integer.parseInt(arg01);
            }
            catch (Exception err) {
                return false;
            }
        }
        return true;
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

    private void initColsMatch() {
        txt.setCellValueFactory(new PropertyValueFactory<Jogos, String>("Time1xTime2"));
        tLocal.setCellValueFactory(new PropertyValueFactory<Jogos, String>("local"));
        tTime1.setCellValueFactory(new PropertyValueFactory<Jogos, Time>("time1"));
        tTime2.setCellValueFactory(new PropertyValueFactory<Jogos, Time>("time2"));
        tg1.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getJogGols(true).toString()));
        tg2.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().getJogGols(false).toString()));
        qtdg1.setCellValueFactory(data -> new ReadOnlyStringWrapper(Integer.toString(data.getValue().getGolsTime1())));
        qtdg2.setCellValueFactory(data -> new ReadOnlyStringWrapper(Integer.toString(data.getValue().getGolsTime2())));

        this.editColsMatch();
    }    


    static ArrayList<Time> getTeams(Time a) {
        ArrayList<Time> t = new ArrayList<Time>();
        for(int i = 0; i < App.listGroup.size(); i++) {
            for(Time timeGetted : App.listGroup.get(i).get()) {
                if(timeGetted != a)
                    t.add(timeGetted);
            }
        }
        return t;
    }

    private void editColsMatch() {
        txt.setCellFactory(TextFieldTableCell.forTableColumn());
        tLocal.setCellFactory(TextFieldTableCell.forTableColumn());
        tTime1.setCellFactory(ChoiceBoxTableCell.<Jogos, Time>forTableColumn((FXCollections.observableArrayList(getTeams(null)))));
        tTime2.setCellFactory(ChoiceBoxTableCell.<Jogos, Time>forTableColumn((FXCollections.observableArrayList(getTeams(t)))));
        tg1.setCellFactory(TextFieldTableCell.forTableColumn());
        tg2.setCellFactory(TextFieldTableCell.forTableColumn());

        tLocal.setOnEditCommit(e -> e.getTableView().getItems().get(e.getTablePosition().getRow()).setLocal(e.getNewValue()));
        tTime1.setOnEditCommit(e -> {
            Jogos match = e.getTableView().getItems().get(e.getTablePosition().getRow());
            match.setTime1(e.getNewValue());
            match.setTime1xTime2(match.getTime1().getNomeTime() + "x" + match.getTime2().getNomeTime());
            this.attTableMatch();
        });
        tTime2.setOnEditCommit(e -> {
            Jogos match = e.getTableView().getItems().get(e.getTablePosition().getRow());
            match.setTime2(e.getNewValue());
            match.setTime1xTime2(match.getTime1().getNomeTime() + "x" + match.getTime2().getNomeTime());
            this.attTableMatch();
        });
        tg1.setOnEditCommit(e -> {
            String localeValue = e.getNewValue();
            if(isArrInt(localeValue)) {
                int[] arr = getArrInt(localeValue);
                Time t = e.getTableView().getItems().get(e.getTablePosition().getRow()).getTime1();
                if(t.has(arr)) {
                    Jogador j[] = t.get(arr);
                    e.getTableView().getItems().get(e.getTablePosition().getRow()).changeGoals(j, true);
                }
            }
        });
        tg2.setOnEditCommit(e -> {
            String localeValue = e.getNewValue();
            if(isArrInt(localeValue)) {
                int[] arr = getArrInt(localeValue);
                Time t = e.getTableView().getItems().get(e.getTablePosition().getRow()).getTime2();
                if(t.has(arr)) {
                    Jogador j[] = t.get(arr);
                    e.getTableView().getItems().get(e.getTablePosition().getRow()).changeGoals(j,false);
                }
            }
        });

        tblViewJogos.setEditable(true);
    }

    private void attTableMatch() {
        for(Jogos j: App.matchs) {
            if(j.getTime1() == t || j.getTime2() == t) {
                tblViewJogos.getItems().add(j);
                tblViewJogos.edit(tblViewJogos.getItems().size() - 1, tTime1);
            }
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

    private void addTeams() {
        for(int i = 0; i < App.listGroup.size(); i++) {
            for(int j = 0; j < App.listGroup.get(i).length(); j++)
                if(App.listGroup.get(i).get(j) != t)
                    time2.getItems().add(App.listGroup.get(i).get(j));
        }
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
        addTeams();
        initColsMatch();
        attTableMatch();
    }    
}
