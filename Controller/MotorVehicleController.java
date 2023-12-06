package Controller;

import Model.MotorVehicleModel;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class MotorVehicleController {
    // member fields:

    MotorVehicleModel model;

    public MotorVehicleController(MotorVehicleModel model){
        this.model = model;
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        model.gas((double) amount/100);
    }
    void brake(int amount) {
        model.brake((double) amount / 100);
    }

    void turboOn(){
        model.turboOn();
    }

    void turboOff(){
        model.turboOff();
    }

    void liftBed(){
        model.liftBed();
    }
    void lowerBed(){
        model.lowerBed();
    }
    void startAllVehicles(){
        model.startAllVehicles();
    }
    void stopAllVehicles(){
        model.stopAllVehicles();
    }

    void addVehicle(){
        model.addRandomVehicle();
    }

    void removeVehicle(){
        model.removeLastVehicle();
    }
}
