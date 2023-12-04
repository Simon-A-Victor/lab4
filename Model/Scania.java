package Model;

import java.awt.*;

public class Scania extends PlatformVehicle {

    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y, 10);
    }

    public void tiltPlatform(double degrees) {

        if (checkIfMaxReached(degrees)){
            setPlatformAngle(70);
        } else if (checkIfMinReached(degrees)) {
            setPlatformAngle(0.0);
        }
        else {
            setPlatformAngle(getPlatformAngle() + degrees);
        }
    }

    private boolean checkIfMaxReached(double degrees){return getPlatformAngle() + degrees > 70;}
    private boolean checkIfMinReached(double degrees){return getPlatformAngle() + degrees < 0;}

    protected double speedFactor() {
        return 1;
    }

}


