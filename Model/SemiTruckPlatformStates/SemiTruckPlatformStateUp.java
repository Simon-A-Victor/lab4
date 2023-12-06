package Model.SemiTruckPlatformStates;

import Model.Car;
import Model.SemiTruck;

public class SemiTruckPlatformStateUp extends SemiTruckPlatformState{
    public SemiTruckPlatformStateUp(SemiTruck truck) {
        super(truck);
    }

    @Override
    public void onMove() {
        truck.moveAsSuper();
    }

    @Override
    public void onGas(double amount) {
        truck.gasAsSuper(amount);
    }

    @Override
    public void onLoad(Car other) {

    }

    @Override
    public void onUnload(Car other) {

    }


}
