package com.lpoo.project.view;

import javafx.scene.control.TextField;

public class NumField extends TextField {
    @Override
    public void replaceText(int arg0, int arg1, String arg2) {
        if(isNum(arg2))
            super.replaceText(arg0, arg1, arg2);
    }
    
    @Override
    public void replaceSelection(String arg0) {
        if(isNum(arg0))
            super.replaceSelection(arg0);
    }

    private boolean isNum(String arg0) {
        return arg0.matches("[0-9]*");
    }
}
