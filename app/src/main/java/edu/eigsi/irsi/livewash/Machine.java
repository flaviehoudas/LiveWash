package edu.eigsi.irsi.livewash;

import android.widget.ImageView;

public class Machine {

    private String state;
    private int numeroMachine;
    private String propriete; /** marque, temps de la machine, programme... dans un @string **/


    public Machine(int numeroMachine, String propriete){
        state = "L";
        this.numeroMachine=numeroMachine;
        this.propriete=propriete;
    }

    Machine(String state){
        this.state = state;
    }

    public String getState(Machine machine) {
        String stateF = state;
        return stateF;
    }

}
