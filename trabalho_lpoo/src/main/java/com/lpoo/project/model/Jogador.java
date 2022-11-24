package com.lpoo.project.model;

public class Jogador extends Pessoa {

    private int numCamisa;
    
    public int getNum() {
        return numCamisa;
    }

    public void setNum(int num) {
        this.numCamisa = num;
    }


    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, int numero , String celular, String dataNascimento, int num, Time time) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, numero), celular, dataNascimento);

        this.numCamisa = num;

        time.addComponent(this);
    }

    public Jogador(String nome, String cpf, String rua, String bairro, String cidade, String cep, int numero , String celular, String dataNascimento, int num, Time time) {
        super(nome, cpf, new Endereco(rua, bairro, cidade, cep, numero), celular, dataNascimento);

        this.numCamisa = num;

        time.addComponent(this);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.numCamisa;
    }
}