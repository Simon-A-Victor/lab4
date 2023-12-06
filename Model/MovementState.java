package Model;

public abstract class MovementState {
    Scania scania;

    public MovementState(Scania vehicle){
        this.scania = vehicle;
    }

    public abstract void onTiltPlatform(double degrees);

}