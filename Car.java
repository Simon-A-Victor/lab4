
import java.awt.*;



abstract class Car extends MotorVehicle implements Movable, Loadable {

    public Car(int nrDoors, Color color, String modelName, double x, double y, int size, double enginePower){
        super(nrDoors, color, modelName, x, y, size, enginePower);
    }
}
