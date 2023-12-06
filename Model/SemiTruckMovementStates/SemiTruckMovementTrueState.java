package Model.SemiTruckMovementStates;

import Model.SemiTruck;
import Model.SemiTruckPlatformStates.SemiTruckPlatformState;

public class SemiTruckMovementTrueState extends SemiTruckMovementState {
    public SemiTruckMovementTrueState(SemiTruck truck) {
        super(truck);
    }

    @Override
    public void onSetPlatformDown() {

    }

    @Override
    public void onSetPlatformUp() {

    }
}
