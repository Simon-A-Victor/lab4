package Model;

import java.awt.*;
import java.util.ArrayList;

public class SemiTruck extends MotorVehicle {

    private final ArrayList<Car> loaded;
    private final int maxSize;
    private final int capacity;
    private boolean platformUp;


    public SemiTruck(double x, double y){
        super(2, Color.black,"Semi69", x, y, 15, 5);
        this.loaded  = new ArrayList<>();
        this.maxSize = 5;
        this.capacity = 4;
        this.platformUp = true;
    }

    public void setPlatformUp() {
        this.platformUp = true;
    }

    public void setPlatformDown(){
        this.platformUp = false;
    }

    public int getMaxSize(){return maxSize;}

    public int getCapacity(){return capacity;}

    private boolean checkSize(Loadable other){
        return other.getSize() <= this.getMaxSize();
    }
    public boolean isLoaded(){
        return !(this.loaded.isEmpty());
    }

    public boolean platformIsDown(){
        return !platformUp;
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

    private boolean checkValidLoad(Car other){
        return this.checkSize(other) && this.platformIsDown() && this.checkDistance(other) && this.checkCapacity();
    }

    public void load(Car other) {
        if (checkValidLoad(other)) {
            loaded.add(other);
            this.alignContents();
        }
    }

    private boolean checkIfLastInArray(Car other){
        return loaded.get(loaded.size() - 1) == other;
    }

    private boolean checkValidUnload(Car other){
        return checkIfLastInArray(other) && this.platformIsDown();
    }

    public void unload(Car other) {
        if (checkValidUnload(other)){
            loaded.remove(other);
            other.setXPosition(other.getXPosition()+1);
            other.setActive();
        }
    }

    private void alignContents(){
        for(Car car : loaded){
            car.setXPosition(this.getXPosition());
            car.setYPosition(this.getYPosition());
            car.setDirection(this.getDirection());
        }
    }
    @Override
    public void turnLeft() {
        super.turnLeft();

        if (isActive()){
            this.alignContents();
        }
    }
    @Override
    public void turnRight() {
        super.turnRight();

        if (isActive()){
            this.alignContents();
        }
    }

    @Override
    double speedFactor() {
        return 1;
    }

    @Override
    public void move() {
        super.move();
        if (this.isActive()){
            this.alignContents();
        }
    }
}
