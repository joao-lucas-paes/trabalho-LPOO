package com.lpoo.project.model;

public class Jogador extends Pessoa {

    private int num;

    Jogador(String nome, String cpf, Endereco endereco, String celular, int num, Time time) {
        super(nome, cpf, endereco, celular);

        this.num = num;

        time.add(this);
    }

    @Override
    public String toString() {
        return this.getNome() + " - " + this.num;
    }
}