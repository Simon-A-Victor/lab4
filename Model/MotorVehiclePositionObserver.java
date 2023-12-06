package Model;

public interface MotorVehiclePositionObserver {
    void actOnMotorVehiclePositionUpdate(int x, int y, String modelName);

    void actOnTickChange();
}
