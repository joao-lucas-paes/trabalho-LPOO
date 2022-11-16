package com.lpoo.project.model;

import java.util.ArrayList;
import java.util.List;

public class Time implements Comparable<Object> {

    public Time(String nomeTime, String nomeSelecao, String grupo) {
        this.nomeTime = nomeTime;
        this.nomeSelecao = nomeSelecao;
        this.grupo = grupo;
        this.listJogadores = new ArrayList<Jogador>();
    }

    private String nomeTime, nomeSelecao, grupo;
    private List<Jogador> listJogadores;
    private int j = 0, p = 0, v = 0, d = 0, e = 0;

    protected void vitoria() {
        j++;
        p += 3;
        v++;
    }

    protected void empate() {
        j++;
        p++;
        e++;
    }

    protected void derota() {
        j++;
        d++;
    }
    
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

    @Override
    public int compareTo(Object arg0) {
        return this.nomeTime.compareTo(((Time) arg0).getNomeTime());
    }

    @Override
    public String toString() {
        return this.nomeTime + " - " + this.nomeSelecao + ": " + this.listJogadores;
    }

    public int getJ() {
        return j;
    }

    public int getP() {
        return p;
    }

    public int getV() {
        return v;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }
}
