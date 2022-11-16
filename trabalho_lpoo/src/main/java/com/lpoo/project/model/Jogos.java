package com.lpoo.project.model;

import java.util.List;

public class Jogos {
    public Jogos(String time1xTime2, int golsTime1, int golsTime2, List<Jogador> gols) {
        Time1xTime2 = time1xTime2;
        this.golsTime1 = golsTime1;
        this.golsTime2 = golsTime2;
        this.gols = gols;
    }

    private String Time1xTime2;
    private int golsTime1, golsTime2;
    private Time time1, time2;
    private List<Jogador> gols;

    public String getTime1xTime2() {
        return Time1xTime2;
    }
    public void setTime1xTime2(String time1xTime2) {
        Time1xTime2 = time1xTime2;
    }
    public int getGolsTime1() {
        return golsTime1;
    }
    public void setGolsTime1(int golsTime1) {
        this.golsTime1 = golsTime1;
    }
    public int getGolsTime2() {
        return golsTime2;
    }
    public void setGolsTime2(int golsTime2) {
        this.golsTime2 = golsTime2;
    }
    public List<Jogador> getGols() {
        return gols;
    }
    public void setGols(List<Jogador> gols) {
        this.gols = gols;
    }
    
    void GerarResultados() {
        if(this.golsTime1 > this.golsTime2) {
            time1.vitoria();
            time2.derota();
        } else if(this.golsTime1 < this.golsTime2) {
            time2.vitoria();
            time1.derota();
        } else {
            time1.empate();
            time2.empate();
        }
    }

    @Override
    public String toString() {
        return this.Time1xTime2 + "\n" + this.golsTime1 + " - " + this.golsTime2 + "\n" + this.gols;
    }
}