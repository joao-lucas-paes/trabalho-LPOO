package com.lpoo.project.model;

import com.lpoo.project.controller.GetCpf;
import com.lpoo.project.view.App;

import javafx.scene.Parent;
import javafx.scene.control.Dialog;

public abstract class Pessoa implements Verificavel {
    
    static Pessoa ref;
    private String nome, cpf, celular, dataNascimento;
    private Endereco endereco;

    Pessoa(String nome, String cpf, Endereco endereco, String celular, String dataNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.celular = celular;
        this.dataNascimento = dataNascimento;
        this.setCpf(cpf);
    }

    // voltar e implementar direito essa funcao
    @Override
    public boolean validar(String codigo) {
        if(codigo.equals("00000000000") || codigo.equals("11111111111") || codigo.equals("22222222222") || codigo.equals("33333333333") || codigo.equals("44444444444") || codigo.equals("55555555555") || codigo.equals("66666666666") || codigo.equals("77777777777") || codigo.equals("88888888888") || codigo.equals("99999999999") || (codigo.length() != 11))
            return false;
            char dig10, dig11;
            int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(codigo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(codigo.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == codigo.charAt(9)) && (dig11 == codigo.charAt(10)))
                 return(true);
            else return(false);
            
        } catch(Exception err) {
            err.printStackTrace();
            return false;
        }

    }

    @Override
    public void solicitarNovo() {
        Pessoa.ref = this;
        Dialog<String> d = new Dialog<String>();

        try {
            Parent p = App.loadFXML("getCpf");
            d.setGraphic(p);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        d.showAndWait();

        this.setCpf(GetCpf.results);
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
        if(!validar(cpf))
            this.solicitarNovo();
        else
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

    public void setEndereco(String endereco) {
        this.endereco.setEndereco(endereco);
    }

}
