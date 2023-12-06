package Model;

import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    public Volvo240(double x, double y) {
        super(4,Color.black,"Volvo240",x,y,2,100);
    }

    protected double speedFactor() {
        return this.getEnginePower() * 0.01 * trimFactor;
    }

}
