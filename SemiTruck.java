import java.awt.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Stack;

public class SemiTruck extends PlatformVehicle{

    private ArrayList<Car> loaded;
    private int maxSize;
    private int capacity;


    public SemiTruck(double x, double y){
        super(2,250, Color.black,"Semi69",x, y, 15);
        this.loaded  = new ArrayList<Car>();
        this.maxSize = 5;
        this.capacity = 4;
        this.setDirection(Directions.NORTH);
    }

    public void setPlatformUp() {
        this.setPlatformAngle(0);
    }

    public void setPlatformDown(){
        this.setPlatformAngle(70);
    }

    @Override
    public double speedFactor() {
        return 1;
    }

    public int getMaxSize(){return maxSize;}

    public int getCapacity(){return capacity;}

    private boolean checkSize(Loadable other){
        return other.getSize() <= this.getMaxSize();
    }
    public boolean isLoaded(){
        return !(this.loaded.isEmpty());
    }

    public boolean platformIsUp(){
        return (this.getPlatformAngle() == 0);
    }
    private boolean checkDistance(Car other){
        double XDiff = Math.abs(this.getXPosition() - other.getXPosition());
        double YDiff = Math.abs(this.getYPosition() - other.getYPosition());
        double totDiff = Math.sqrt(XDiff*XDiff + YDiff*YDiff);
        return (totDiff < 4);
    }
    private boolean checkCapacity(){
        return this.loaded.size() < this.capacity;
    }

    public void load(Car other) {
        if (this.checkSize(other) && !this.platformIsUp() && this.checkDistance(other) && this.checkCapacity()){
            loaded.add(other);
            this.alignContents();
        }
    }

    public void unload(Car other) {
        if (loaded.getLast() == other && !this.platformIsUp()){
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
        this.alignContents();
    }
    @Override
    public void turnRight() {
        super.turnRight();
        this.alignContents();
    }
    @Override
    public void move() {
            super.move();
            this.alignContents();
    }
}
