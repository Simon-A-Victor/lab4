import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<MotorVehicle> cars = new ArrayList<>();
    Volvo240 volvo;
    Saab95 saab;
    Scania scania;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();
        cc.volvo = new Volvo240(0,0);
        cc.volvo.setDirection(Directions.SOUTH);
        cc.saab = new Saab95(0,100);
        cc.scania = new Scania(0, 200);
        cc.cars.add(cc.volvo);
        cc.cars.add(cc.saab);
        cc.cars.add(cc.scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (MotorVehicle car : cars) {
                handleWallCollision(car);
                car.move();
                int x = (int) Math.round(car.getXPosition());
                int y = (int) Math.round(car.getYPosition());
                frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (MotorVehicle car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (MotorVehicle car : cars){
            car.brake(brake);
        }

    }

    void turboOn(){
        saab.setTurboOn();
    }

    void turboOff(){
        saab.setTurboOff();
    }

    void liftBed(){
        scania.tiltPlatform(-70);
    }
    void lowerBed(){
        scania.tiltPlatform(70);
    }

    private void handleWallCollision(MotorVehicle car){
            if (checkWallCollisions(car)){
                car.stopEngine();
                invertDirection(car);
                car.startEngine();
            }
    }

    private boolean checkWallCollisions(MotorVehicle car){
        return (checkBottomWallCollision(car) || checkTopWallCollision(car) || checkRightWallCollision(car) || checkLeftWallCollision(car));
    }
    private boolean checkLeftWallCollision(MotorVehicle car){
        return car.getDirection() == Directions.WEST && car.getXPosition() < 0;
    }

    private boolean checkRightWallCollision(MotorVehicle car){
        return car.getDirection() == Directions.EAST &&car.getXPosition() + 100 > 800;
    }

    private boolean checkTopWallCollision(MotorVehicle car){
        return car.getDirection() == Directions.NORTH && car.getYPosition() < 0;
    }

    private boolean checkBottomWallCollision(MotorVehicle car){
        return car.getDirection() == Directions.SOUTH && car.getYPosition() + 60 > 660;
    }

    void invertDirection(MotorVehicle car){
        car.setDirection(Directions.values()[(car.getDirection().ordinal()+2)%4]);
    }

}
