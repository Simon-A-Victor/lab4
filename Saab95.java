import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;


    public Saab95(double x, double y) {
        super(2, Color.red,  "Saab95", x, y, 2, 125);
        turboOn = false;
    }


    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    protected double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }
}

