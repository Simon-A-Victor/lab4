package Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class MotorVehicleModel {
    // Smart, here is all the logic which should keep track of all info relevant to the game.
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    public ArrayList<MotorVehicle> vehicles;

    private final ArrayList<MotorVehiclePositionObserver> observers = new ArrayList<>();

    public MotorVehicleModel(ArrayList<MotorVehicle> vehicles){
        this.vehicles = vehicles;
        this.timer.start();
    }

    private int worldSizeX = 800;

    private int worldSizeY = 560;

    public int getWorldSizeX(){return worldSizeX;}
    public int getWorldSizeY(){return worldSizeY;}





    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorVehicle car : vehicles) {
                car.move();
                handleWallCollision(car);
                int x = (int) Math.round(car.getXPosition());
                int y = (int) Math.round(car.getYPosition());
                multiCastPositionChange(x, y, car.getModelName());
            }
            multiCastTickUpdate();
        }
    }

    private void handleWallCollision(MotorVehicle car){
        boolean collision = false;
        if (checkTopWallCollision(car)){
            car.setYPosition(0);
            collision = true;
        }
        else if (checkBottomWallCollision(car)){
            car.setYPosition(560);
            collision = true;
        }
        else if (checkLeftWallCollision(car)){
            car.setXPosition(0);
            collision = true;
        } else if (checkRightWallCollision(car)) {
            car.setXPosition(700);
            collision = true;
        }
        if (collision){
            car.stopEngine();
            invertDirection(car);
            car.startEngine();
        }
    }

    private boolean checkLeftWallCollision(MotorVehicle car){
        return car.getXPosition() < 0;
    }

    private boolean checkRightWallCollision(MotorVehicle car){
        return car.getXPosition() + 100  > 800;
    }

    private boolean checkTopWallCollision(MotorVehicle car){
        return car.getYPosition()  < 0;
    }

    private boolean checkBottomWallCollision(MotorVehicle car){
        return car.getYPosition() + 60 > 560;
    }

    void invertDirection(MotorVehicle car){
        car.setDirection(Directions.values()[(car.getDirection().ordinal()+2)%4]);
    }

    public void addObserver(MotorVehiclePositionObserver observer){observers.add(observer);}

    public void removeObserver(MotorVehiclePositionObserver observer){observers.remove(observer);}

    private void multiCastPositionChange(int x, int y , String modelName){
        for (MotorVehiclePositionObserver observer: observers){
            observer.actOnMotorVehiclePositionUpdate(x, y, modelName);
        }
    }

    private void multiCastTickUpdate(){
        for (MotorVehiclePositionObserver observer: observers){
            observer.actOnTickChange();
        }
    }

}
