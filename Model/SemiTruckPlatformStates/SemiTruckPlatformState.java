package Model.SemiTruckPlatformStates;


import Model.Car;
import Model.SemiTruck;

public abstract class SemiTruckPlatformState {
    SemiTruck truck;

    public SemiTruckPlatformState(SemiTruck truck){
        this.truck = truck;
    }

    public abstract void onMove();

    public abstract void onGas(double amount);

    public abstract void onLoad(Car other);

    public abstract void onUnload(Car other);

    public void setStateUp(){truck.platformState = new SemiTruckPlatformStateUp(truck);}

    public void setStateDown(){truck.platformState = new SemiTruckPlatformStateDown(truck);}
}
