package Model;

import Model.MovementStates.MovementState;
import Model.MovementStates.MovementTrueState;
import Model.ScaniaMovementStates.ScaniaMovementFalseState;
import Model.ScaniaMovementStates.ScaniaMovementState;
import Model.ScaniaMovementStates.ScaniaMovementStateTrue;

import java.awt.*;

public class Scania extends PlatformVehicle {
    ScaniaMovementState movementState;
    public Scania(double x, double y) {
        super(2, 250, Color.black, "Scania", x, y, 10);
        this.movementState = new ScaniaMovementFalseState(this);
    }

    public void tiltPlatform(double degrees) {
        this.movementState.onTiltPlatform(degrees);
    }

    public boolean checkIfMaxReached(double degrees){return getPlatformAngle() + degrees > 70;}
    public boolean checkIfMinReached(double degrees){return getPlatformAngle() + degrees <= 0;}

    protected double speedFactor() {
        return 1;
    }

    @Override
    public void gas(double amount){
        super.gas(amount);
    }

    @Override
    public void setMovementStateTrue(){movementState = new ScaniaMovementStateTrue(this);
    }

    @Override
    public void setMovementStateFalse(){movementState = new ScaniaMovementFalseState(this);}

}


