package com.lpoo.project.model;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class Grupo {
    private ArrayList<Time> Times;

    public void add(Time t) {
        this.Times.add(t);
    }

    public void rm(int t) {
        this.Times.remove(t);
    }

    public void sort() {
        this.Times.sort(null);
    }

    public Time get(int index) {
        return this.Times.get(index);
    }

    public int length() {
        return this.Times.size();
    }

    public Label[] generateSpecifyAttr(int i) {
       Label[] value = {new Label(this.get(i).getNomeTime()), new Label(this.get(i).getNomeSelecao()), new Label(Integer.toString(this.get(i).getP())), new Label(Integer.toString(this.get(i).getJ())), new Label(Integer.toString(this.get(i).getD())), new Label(Integer.toString(this.get(i).getE()))};
        return value;
    }

    public Grupo(ArrayList<Time> t) {
        Times = t;
    }

    @Override
    public String toString() {
        return "Grupo:" + this.Times;
    }
}
