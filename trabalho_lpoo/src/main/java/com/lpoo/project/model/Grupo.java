package com.lpoo.project.model;

import java.util.ArrayList;

public class Grupo {
    private ArrayList<Time> Times;

    public void add(Time t) {
        this.Times.add(t);
    }

    public Grupo(ArrayList<Time> t) {
        Times = t;
    }

    @Override
    public String toString() {
        return "Grupo:" + this.Times;
    }
}
