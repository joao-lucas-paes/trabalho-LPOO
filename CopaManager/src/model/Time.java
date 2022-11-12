package model;

import java.util.ArrayList;
import java.util.List;

public class Time {

    public Time(String nomeTime, String nomeSelecao, String grupo) {
        this.nomeTime = nomeTime;
        this.nomeSelecao = nomeSelecao;
        this.grupo = grupo;
        this.listJogadores = new ArrayList<Jogador>();
    }

    private String nomeTime, nomeSelecao, grupo;
    private List<Jogador> listJogadores;
    
    void add(Jogador j) {
        this.listJogadores.add(j);
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public void setNomeTime(String nomeTime) {
        this.nomeTime = nomeTime;
    }

    public String getNomeSelecao() {
        return nomeSelecao;
    }

    public void setNomeSelecao(String nomeSelecao) {
        this.nomeSelecao = nomeSelecao;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public List<Jogador> getListJogadores() {
        return listJogadores;
    }

    public void setListJogadores(List<Jogador> listJogadores) {
        this.listJogadores = listJogadores;
    }
}
