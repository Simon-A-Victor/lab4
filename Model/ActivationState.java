package Model;

public abstract class ActivationState {
    MotorVehicle vehicle;
    public ActivationState(MotorVehicle vehicle){
        this.vehicle = vehicle;
    }

    public void onMove(){

    }
    public void onTurnLeft(){

    }
    public void onTurnRight(){

    }
    public void onGas(){

    }

}
