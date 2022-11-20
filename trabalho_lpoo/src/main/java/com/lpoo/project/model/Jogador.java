package com.lpoo.project.model;

import com.lpoo.project.controller.EditTeam;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;

public class Jogador extends Pessoa {

    private int num;
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, int numero , String celular, String dataNascimento, int num, Time time) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, numero), celular, dataNascimento);

        this.num = num;

        time.addComponent(this);
    }

    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, String cep, int numero , String celular, String dataNascimento, int num, Time time) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, cep, numero), celular, dataNascimento);

        this.num = num;

        time.addComponent(this);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.num;
    }
}