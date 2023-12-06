package Model;

import java.awt.image.ConvolveOp;
import java.util.Random;


import Model.MotorVehicleModel;
import Model.MotorVehicle;

public class MotorVehicleFactory {
    public void MotorVehicleFactory(){

    };

    public static Volvo240 createVolvo240(double x, double y){
        Volvo240 newVolvo = new Volvo240(x, y);

        return newVolvo;
    };

    public static Saab95 createSaab95(double x, double y){
        Saab95 newSaab = new Saab95(x, y);

        return newSaab;
    };

    public static Scania createScania(double x, double y){
        Scania newScania = new Scania(x, y);

        return newScania;
    };

    public static SemiTruck createSemiTruck(double x, double y){
        SemiTruck newSemiTruck = new SemiTruck(x, y);

        return newSemiTruck;
    };
    public static MotorVehicle createRandomVehicle(){
        Random rand = new Random();

        int n = rand.nextInt(3);

        double x = rand.nextDouble(Model.MotorVehicleModel.getWorldSizeX()-100);
        double y = rand.nextDouble(Model.MotorVehicleModel.getWorldSizeY()-60);

        MotorVehicle newVehicle;

        switch(n){
            case 0:
                newVehicle = createVolvo240(x, y);
                break;
            case 1:
                newVehicle = createSaab95(x, y);
                break;
            case 2:
                newVehicle = createScania(x, y);
                break;
            default:
                newVehicle = createVolvo240(x, y);
        }

        newVehicle.setDirection(Directions.randomDirection());

        return newVehicle;
    };
}
