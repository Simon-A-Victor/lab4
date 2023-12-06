package Model.SemiTruckPlatformStates;

import Model.Car;
import Model.SemiTruck;

public class SemiTruckPlatformStateDown extends SemiTruckPlatformState{
    public SemiTruckPlatformStateDown(SemiTruck truck) {
        super(truck);
    }

    public void onMove(){
        truck.moveAsSuper();
    }

    @Override
    public void onLoad(Car other) {
        if (truck.checkValidLoad(other)) {
            truck.loaded.add(other);
            truck.alignContents();
        }
    }

    @Override
    public void onUnload(Car other) {
        if (truck.checkValidUnload(other)){
            truck.loaded.remove(other);
            other.setXPosition(other.getXPosition()+1);
            other.setActive();
        }
    }
}
