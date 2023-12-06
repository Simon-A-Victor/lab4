package Controller;

import Model.MotorVehicleModel;
import Model.MotorVehicle;
import Model.Saab95;
import Model.Scania;

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
        double gas = ((double) amount) / 100;
        for (MotorVehicle car : model.vehicles) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : model.vehicles){
            car.brake(brake);
        }

    }

    void turboOn(){
        for (MotorVehicle car : model.vehicles){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void turboOff(){
        for (MotorVehicle car : model.vehicles){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void liftBed(){
        for (MotorVehicle car: model.vehicles){
            if(car instanceof Scania){
                ((Scania) car).tiltPlatform(-70);
        }}
    }
    void lowerBed(){
        for (MotorVehicle car : model.vehicles){
            if(car instanceof Scania){
                ((Scania) car).tiltPlatform(70);
            }}
    }
    void startAllVehicles(){
        for(MotorVehicle car : model.vehicles){
            car.startEngine();
        }
    }
    void stopAllVehicles(){
        for(MotorVehicle car: model.vehicles){
            car.stopEngine();
        }
    }
}
