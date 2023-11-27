import java.util.ArrayList;

public class Workshop<V extends MotorVehicle>{

    private double x;
    private double y;
    private int capacity;
    private int maxSize;
    private ArrayList<V> storage;

    public Workshop(double x, double y, int capacity, int maxSize){
        this.x = x;
        this.y = y;
        this.maxSize = maxSize;
        this.capacity = capacity;
        storage = new ArrayList<V>();
    }
    private int getCapacity() {
        return capacity;
    }
    private double getXPosition(){return x;}
    private double getYPosition(){return y;}

    private boolean checkDistance(V other){
        double XDiff = Math.abs(this.getXPosition() - other.getXPosition());
        double YDiff = Math.abs(this.getYPosition() - other.getYPosition());
        double totDiff = Math.sqrt(XDiff*XDiff + YDiff*YDiff);
        return (totDiff < 4);
    }

    private boolean checkCapacity(ArrayList<V> storage, int capacity){
        return storage.size() < capacity;
    }

    private boolean checkSize(V other){
        return other.getSize() <= this.maxSize;
    }

    private boolean checkValid(V other){
        return this.checkDistance(other) && this.checkCapacity(storage, this.getCapacity()) && !storage.contains(other) && checkSize(other);

    }

    public void load(V other){
        if (checkValid(other)){
            storage.add(other);
            other.setCurrentSpeed(0.0);
            other.setXPosition(this.getXPosition());
            other.setYPosition(this.getYPosition());
            other.setInactive();
        }
    }

    public void unload(V other){
        if (storage.contains(other)){
            storage.remove(other);
            other.setXPosition(other.getXPosition()+1);
            other.setActive();
        }
    }
}
