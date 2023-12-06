package Model.ScaniaMovementStates;

import Model.MotorVehicle;
import Model.Scania;

public class ScaniaMovementFalseState extends ScaniaMovementState{
    public ScaniaMovementFalseState(Scania vehicle) {
        super(vehicle);
    }

    @Override
    public void onTiltPlatform(double degrees) {
        if(vehicle.checkIfMaxReached(degrees)){
            vehicle.setPlatformAngle(70);
            vehicle.platformState = vehicle.platformDown();
        } else if (vehicle.checkIfMinReached(degrees)) {
            vehicle.setPlatformAngle(0.0);
            vehicle.platformState = vehicle.platformUp();
        }
        else {
            vehicle.setPlatformAngle(vehicle.getPlatformAngle()+degrees);
            vehicle.platformState = vehicle.platformDown();
        }
    }
}
