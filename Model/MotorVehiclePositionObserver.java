package Model;

public interface MotorVehiclePositionObserver {
    public void actOnMotorVehiclePositionUpdate(int x, int y, String modelName);

    public void actOnTickChange();
}
