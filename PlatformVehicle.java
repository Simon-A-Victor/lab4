import java.awt.*;

abstract class PlatformVehicle extends Vehicle {
    private double platformAngle = 0.0;
    private int nrDoors;
    private double enginePower;
    private boolean loaded;
    private int size;
    private double getEnginePower;

    abstract double speedFactor();


    public PlatformVehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, int size) {
        super(color, modelName, x, y, size);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.loaded = false;
        this.size = size;

    }

    protected void incrementSpeed(double amount) {
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, getEnginePower()));
    }

    protected void decrementSpeed(double amount) {
        setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
    }

    protected double getPlatformAngle() {
        return platformAngle;
    }

    protected void setPlatformAngle(double degrees) {
        platformAngle = degrees;
    }

    protected boolean platformIsUp() {
        return getPlatformAngle() == 0.0;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public boolean isStationary() {
        double speed = getCurrentSpeed();
        return speed == 0;
    }

    public void gas(double amount) {
        if (0 <= amount && amount <= 1 && platformIsUp()) {
            this.incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (0 <= amount && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
