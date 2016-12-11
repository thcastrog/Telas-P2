package br.java.android.Telas;

import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by thayn on 10/12/2016.
 */

public class InstanciaVisao implements Telas {

    private CheckBox tarefaCheckBox;
    private LinearLayout celularLayout;

    public CheckBox getTarefaCheckBox(){
        return tarefaCheckBox;
    }

    public void setTarefaCheckBox(CheckBox tarefaCheckBox){
        this.tarefaCheckBox = tarefaCheckBox;
    }

    public LinearLayout getCelularLayout(){
        return celularLayout;
    }

    public void setCelularLayout(LinearLayout celularLayout){
        this.celularLayout = celularLayout;
    }
}

