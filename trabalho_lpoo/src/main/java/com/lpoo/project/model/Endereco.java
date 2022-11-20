package com.lpoo.project.model;

public class Endereco {
    /**
     * @apiNote cria Endereco com cep
     * @param rua string relativa a rua
     * @param bairro string com o nome do bairro
     * @param cidade string com o nome da cidade
     * @param cep string com o cep
     * @param numero numero do endereco
     */
    public Endereco(String rua, String bairro, String cidade, String cep, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.numero = numero;
    }

    /**
     * @apiNote cria Endereco sem cep
     * @param rua string relativa a rua
     * @param bairro string com o nome do bairro
     * @param cidade string com o nome da cidade
     * @param numero numero do endereco
     */
    public Endereco(String rua, String bairro, String cidade, int numero) {
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = "N/Informado";
    }

    private String rua, bairro, cidade, cep;
    private int numero;

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEndereco(String a) {
        String[] values = a.split(" - ");
        String[] newValue =  {values[0], values[1].split(", ")[0], values[1].split(", ")[1], values[2], values[3]};

        try {
            this.setNumero(Integer.parseInt(newValue[2]));
        } catch (Exception e) {
            System.out.println("Error, unable to set new value to \"Endereco.numero\"");
        } finally {
            this.setCidade(newValue[0]);
            this.setRua(newValue[1]);
            this.setBairro(newValue[3]);
            this.setCidade(newValue[4]);
        }

    }

    @Override
    public String toString() {
        return this.cidade + " - " + this.rua + ", " + this.numero + " - " + this.bairro + " - " + this.cep;
    }
}
