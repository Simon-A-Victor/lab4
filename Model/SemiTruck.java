package Model;

import Model.SemiTruckPlatformStates.SemiTruckPlatformState;
import Model.SemiTruckPlatformStates.SemiTruckPlatformStateUp;

import java.awt.*;
import java.util.ArrayList;

public class SemiTruck extends MotorVehicle {

    public final ArrayList<Car> loaded;
    private final int maxSize;
    private final int capacity;

    public SemiTruckPlatformState platformState;


    public SemiTruck(double x, double y){
        super(2, Color.black,"Semi69", x, y, 15, 5);
        this.loaded  = new ArrayList<>();
        this.maxSize = 5;
        this.capacity = 4;
        this.platformState = new SemiTruckPlatformStateUp(this);
    }

    public void setPlatformUp() {
        platformState.setStateUp();
    }

    public void setPlatformDown(){
        platformState.setStateDown();
    }

    public int getMaxSize(){return maxSize;}

    public int getCapacity(){return capacity;}

    private boolean checkSize(Loadable other){
        return other.getSize() <= this.getMaxSize();
    }
    public boolean isLoaded(){
        return !(this.loaded.isEmpty());
    }

    private boolean checkDistance(Car other){
        double XDiff = Math.abs(this.getXPosition() - other.getXPosition());
        double YDiff = Math.abs(this.getYPosition() - other.getYPosition());
        double totDiff = Math.sqrt(XDiff*XDiff + YDiff*YDiff);
        return (totDiff < 4);
    }
    private boolean checkCapacity(){
        return this.loaded.size() < this.getCapacity();
    }

    public boolean checkValidLoad(Car other){
        return this.checkSize(other) && this.checkDistance(other) && this.checkCapacity();
    }

    public void load(Car other) {
        platformState.onLoad(other);
    }

    private boolean checkIfLastInArray(Car other){
        return loaded.get(loaded.size() - 1) == other;
    }

    public boolean checkValidUnload(Car other){
        return checkIfLastInArray(other);
    }

    public void unload(Car other) {
        platformState.onUnload(other);
    }

    public void alignContents(){
        for(Car car : loaded){
            car.setXPosition(this.getXPosition());
            car.setYPosition(this.getYPosition());
            car.setDirection(this.getDirection());
        }
    }
    @Override
    public void turnLeft() {
        super.turnLeft();
        this.alignContents();
    }
    @Override
    public void turnRight() {
        super.turnRight();
            this.alignContents();
    }

    @Override
    double speedFactor() {
        return 1;
    }

    @Override
    public void move() {
        platformState.onMove();
    }

    public void moveAsSuper(){
        super.move();
        this.alignContents();
    }
}
