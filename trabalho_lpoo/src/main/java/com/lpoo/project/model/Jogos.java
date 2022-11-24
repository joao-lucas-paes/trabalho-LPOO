package com.lpoo.project.model;

import java.util.ArrayList;
import java.util.List;

public class Jogos {
    public Jogos(String time1xTime2, int golsTime1, int golsTime2, List<Jogador> gols, String local) {
        Time1xTime2 = time1xTime2;
        this.golsTime1 = golsTime1;
        this.golsTime2 = golsTime2;
        this.gols = gols;
        this.local = local;
    }

    private String Time1xTime2, local;
    private int golsTime1, golsTime2;
    private Time time1, time2;
    private List<Jogador> gols;


    public void changeGoals(Jogador[] jo, boolean time1) {
        ArrayList<Jogador> j = new ArrayList<Jogador>();
        for(Jogador jogador : jo)
            j.add(jogador);
        
        if(time1) {
            for(int i = this.getGolsTime1(); i < this.getGols().size(); i++) {
                j.add(this.getGols().get(i));
            }
            this.gols = j;
        } else {
            ArrayList<Jogador> merge = new ArrayList<Jogador>();
            for(int i = 0; i < this.getGolsTime1(); i++) {
                merge.add(this.getGols().get(i));
            }
            for(Jogador jogador:j)
                merge.add(jogador);
            
            this.gols = merge;
        }
    }

    public Time getTime2() {
        return time2;
    }
    public void setTime2(Time time2) {
        this.time2 = time2;
    }
    public Time getTime1() {
        return time1;
    }
    public void setTime1(Time time1) {
        this.time1 = time1;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
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
    public ArrayList<Jogador> getJogGols(boolean time1) {
        ArrayList<Jogador> gols = new ArrayList<Jogador>();
        if(time1) {
            for(int i = 0; i < this.golsTime1; i++) {
                gols.add(this.gols.get(i));
            }
        } else {
            for(int i = this.golsTime1; i < this.gols.size(); i++) {
                gols.add(this.gols.get(i));
            }
        }
        return gols;
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