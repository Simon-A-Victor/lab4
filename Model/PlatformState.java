package Model;

public abstract class PlatformState {
    MotorVehicle vehicle;
    public PlatformState(MotorVehicle vehicle){
        this.vehicle = vehicle;
    }

    public abstract boolean allowMove();
}