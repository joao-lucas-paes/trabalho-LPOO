package com.lpoo.project.model;

public abstract class Pessoa implements Verificavel {
    
    private String nome, cpf, celular, dataNascimento;
    private Endereco endereco;

    Pessoa(String nome, String cpf, Endereco endereco, String celular) {
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
        if(validar(cpf)) {
            this.cpf = cpf;
        }
    }

    // voltar e implementar direito essa funcao
    @Override
    public boolean validar(String codigo) {
        return this.cpf == null || codigo == this.cpf;
    }

    @Override
    public void solicitarNovo() {
        // voltar depois e implementar uma forma de solicitar o cpf dnv
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
