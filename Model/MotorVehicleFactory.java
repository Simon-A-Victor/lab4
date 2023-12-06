package Model;

import java.util.Random;

public class MotorVehicleFactory {

    public static Volvo240 createVolvo240(double x, double y){
        return new Volvo240(x, y);
    }

    public static Saab95 createSaab95(double x, double y){
        return new Saab95(x, y);
    }

    public static Scania createScania(double x, double y){
        return new Scania(x, y);
    }

    public static SemiTruck createSemiTruck(double x, double y){
        return new SemiTruck(x, y);
    }
    public static MotorVehicle createRandomVehicle(){
        Random rand = new Random();

        int n = rand.nextInt(3);

        double x = rand.nextDouble(Model.MotorVehicleModel.getWorldSizeX()-100);
        double y = rand.nextDouble(Model.MotorVehicleModel.getWorldSizeY()-60);

        MotorVehicle newVehicle = switch (n) {
            case 1 -> createSaab95(x, y);
            case 2 -> createScania(x, y);
            default -> createVolvo240(x, y);
        };

        newVehicle.setDirection(Directions.randomDirection());

        return newVehicle;
    }
}
