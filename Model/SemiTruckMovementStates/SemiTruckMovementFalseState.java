package Model.SemiTruckMovementStates;

import Model.SemiTruck;

public class SemiTruckMovementFalseState extends SemiTruckMovementState{
    public SemiTruckMovementFalseState(SemiTruck truck) {
        super(truck);
    }

    @Override
    public void onSetPlatformDown() {
        truck.platformState.setStateDown();
    }

    @Override
    public void onSetPlatformUp() {
        truck.platformState.setStateUp();
    }
}
