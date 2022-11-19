package com.lpoo.project.model;

import javafx.scene.control.Button;

public class Jogador extends Pessoa {

    private int num;
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private Button updt;

    public Button getUpdt() {
        return updt;
    }

    public void setUpdt(Button updt) {
        this.updt = updt;
    }

    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, int numero , String celular, String dataNascimento, int num, Time time, Button updt) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, numero), celular, dataNascimento);

        this.num = num;
        this.updt = updt;

        time.add(this);
    }

    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, String cep, int numero , String celular, String dataNascimento, int num, Time time, Button updt) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, cep, numero), celular, dataNascimento);

        this.num = num;
        this.updt = updt;

        time.add(this);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.num;
    }
}