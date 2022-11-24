package com.lpoo.project.model;

import java.util.ArrayList;
import java.util.Comparator;

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
        Times.sort(new Comparator<Object>() {

            @Override
            public int compare(Object arg0, Object arg1) {
                Time t1 = (Time) arg0, t2 = (Time) arg1;
                if(t1.getP() > t2.getP())
                    return -1;
                else if(t1.getP() == t2.getP())
                    return 0;
                return 1;
            }
            
        });
    }

    public ArrayList<Time> get() {
        return this.Times;
    }

    public Time get(int index) {
        return this.Times.get(index);
    }

    public int length() {
        return this.Times.size();
    }

    public Label[] generateSpecifyAttr(int i) {
       Label[] value = {new Label(this.get(i).getNomeTime()), new Label(this.get(i).getNomeSelecao()), new Label(Integer.toString(this.get(i).getP())), new Label(Integer.toString(this.get(i).getJ())), new Label(Integer.toString(this.get(i).getV())), new Label(Integer.toString(this.get(i).getD())), new Label(Integer.toString(this.get(i).getE()))};
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
