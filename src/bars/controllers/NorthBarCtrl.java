package bars.controllers;

import bars.NorthBar;

public class NorthBarCtrl {

    private NorthBar northBar;

    public NorthBarCtrl(NorthBar northBar){
        this.northBar = northBar;


    }

    public void loadFile() {
        System.out.println("LOAD");
    }

    public void saveFile() {
        System.out.println("SAVE");
    }
}
