package Model;

public class MovementFalseState extends MovementState {
    public MovementFalseState(Scania vehicle) {
        super(vehicle);
    }

    public void onTiltPlatform(double degrees) {
        scania.tiltPlatform(degrees);
    }
}
