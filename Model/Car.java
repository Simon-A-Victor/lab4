package Model;

import java.awt.*;



public abstract class Car extends MotorVehicle {
    public Car(int nrDoors, Color color, String modelName, double x, double y, int size, double enginePower){
        super(nrDoors, color, modelName, x, y, size, enginePower);
    }
}
