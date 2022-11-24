package com.lpoo.project.model;

import java.util.ArrayList;

public class Time implements Comparable<Object> {

    public Time(String nomeTime, String nomeSelecao, String grupo) {
        this.nomeTime = nomeTime;
        this.nomeSelecao = nomeSelecao;
        this.grupo = grupo;
        this.listJogadores = new ArrayList<Jogador>();
    }

    private String nomeTime, nomeSelecao, grupo;
    private ArrayList<Jogador> listJogadores;
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

    public boolean has(int[] arr) {
        for(int i: arr) {
            boolean h = false;
            for(int j = 0; j < this.listJogadores.size(); j++)
                if (i == this.listJogadores.get(j).getNum()) {
                    h = true;
                    break;
                }
            if(!h) 
                return false;
            
        }

        return true;
    }

    public Jogador[] get(int[] arr) {
        Jogador jogador[] = new Jogador[arr.length];
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < this.listJogadores.size(); j++)
                if (arr[i] == this.listJogadores.get(j).getNum()) {
                    jogador[i] = this.listJogadores.get(j);
                    break;
                }
        }
        return jogador;
    }
    
    public void addComponent(Jogador j) {
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

    public ArrayList<Jogador> getListJogadores() {
        return listJogadores;
    }

    public void setListJogadores(ArrayList<Jogador> jogador) {
        this.listJogadores = jogador;
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
