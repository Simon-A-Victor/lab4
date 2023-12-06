package Model.ScaniaMovementStates;

import Model.Scania;

public class ScaniaMovementStateTrue extends ScaniaMovementState{
    public ScaniaMovementStateTrue(Scania vehicle) {
        super(vehicle);
    }

    @Override
    public void onTiltPlatform(double degrees) {

    }
}
