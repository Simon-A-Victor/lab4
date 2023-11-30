package Application;

public interface MotorVehiclePositionObserver {
    public void actOnMotorVehiclePositionUpdate(int x, int y, int motorVehicleIndex);

    public void actOnTickChange();
}
