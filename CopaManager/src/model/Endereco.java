package model;

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
}
