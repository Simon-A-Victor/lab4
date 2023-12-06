package Model.ScaniaMovementStates;

import Model.Scania;

public class ScaniaMovementFalseState extends ScaniaMovementState{
    public ScaniaMovementFalseState(Scania vehicle) {
        super(vehicle);
    }

    @Override
    public void onTiltPlatform(double degrees) {
        if(vehicle.checkIfMaxReached(degrees)){
            vehicle.setPlatformAngle(70);
            vehicle.platFormVehiclePlatformState = vehicle.platformDown();
        } else if (vehicle.checkIfMinReached(degrees)) {
            vehicle.setPlatformAngle(0.0);
            vehicle.platFormVehiclePlatformState = vehicle.platformUp();
        }
        else {
            vehicle.setPlatformAngle(vehicle.getPlatformAngle()+degrees);
            vehicle.platFormVehiclePlatformState = vehicle.platformDown();
        }
    }
}
