package com.tns.custominterface;

/**
 * Created by TNS on 01-Jun-17.
 */

public class CustomModel {
    boolean state;
    private static CustomModel getCustomModelInstance;


    interface CustomInterfeceListner{
        void statechanged(String hello);
    }
    public CustomInterfeceListner customInterfeceListner;


    public boolean getstate() {
        return state;
    }

    public static CustomModel getGetCustomModelInstance() {
        if(getCustomModelInstance == null)
        {
            getCustomModelInstance= new CustomModel();

        }

        return getCustomModelInstance;
    }


    public void changeState(boolean state,String value) {
        if(customInterfeceListner != null) {
            this.state = state;
            notifyStateChange(value);
        }
    }



    public void setCustomInterfeceListner(CustomInterfeceListner customInterfeceListner) {
        this.customInterfeceListner = customInterfeceListner;
    }

    private void notifyStateChange(String h) {
        customInterfeceListner.statechanged(h);
    }
}
