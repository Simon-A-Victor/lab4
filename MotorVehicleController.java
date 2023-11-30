import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class MotorVehicleController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    // private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    //MotorVehicleView frame;
    // A list of cars, modify if needed
    //ArrayList<MotorVehicle> cars = new ArrayList<>();
    //Volvo240 volvo;
    //Saab95 saab;
    //Scania scania;

    //methods:

    public static void MotorVehicleController(String[] args) {
        // Instance of this class
        //MotorVehicleController cc = new MotorVehicleController();
        //ArrayList<String> modelNames = new ArrayList<String>();
        //cc.volvo = new Volvo240(0,0);
        //cc.volvo.setDirection(Directions.SOUTH);
        //cc.saab = new Saab95(0,100);
        //cc.scania = new Scania(0, 200);
        //cc.cars.add(cc.volvo);
        //cc.cars.add(cc.saab);
        //cc.cars.add(cc.scania);


        // Note: should use .contains() to check for only unique values
        // this is not needed now because we KNOW it won't in this stage take in
        // duplicate values
        //for ( MotorVehicle car : cc.cars
        //     ) {
        //    modelNames.add(car.getModelName());
        //}

        // Start a new view and send a reference of self
        //cc.frame = new MotorVehicleView("CarSim 1.0", cc, modelNames);
        // Start the timer
        // cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    //private class TimerListener implements ActionListener {
      //  public void actionPerformed(ActionEvent e) {
        //    for (MotorVehicle car : cars) {
          //      car.move();
            //    handleWallCollision(car);
              //  int x = (int) Math.round(car.getXPosition());
                //int y = (int) Math.round(car.getYPosition());
                //frame.drawPanel.moveit(x, y, cars.indexOf(car));
                // repaint() calls the paintComponent method of the panel
                //frame.drawPanel.repaint();
            //}
        //}
    //}

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
        for (MotorVehicle car : model.vehicles){
            //if(car instanceof Saab95){
            ((Saab95) car).setTurboOn();
            //}
        }
    }

    void turboOff(){
        for (MotorVehicle car : model.vehicles){
            //if(car instanceof Saab95){
            ((Saab95) car).setTurboOff();
            //}
        }
    }

    void liftBed(){
        scania.tiltPlatform(-70);
    }
    void lowerBed(){
        scania.tiltPlatform(70);
    }
    void startAllVehicles(){
        for(MotorVehicle car : cars){
            car.startEngine();
        }
    }
    void stopAllVehicles(){
        for(MotorVehicle car: cars){
            car.stopEngine();
        }
    }

    //private void handleWallCollision(MotorVehicle car){
    //    boolean collision = false;
    //    if (checkTopWallCollision(car)){
    //        car.setYPosition(0);
    //        collision = true;
    //    }
    //    else if (checkBottomWallCollision(car)){
    //        car.setYPosition(560);
    //        collision = true;
    //    }
    //    else if (checkLeftWallCollision(car)){
    //        car.setXPosition(0);
    //        collision = true;
    //    } else if (checkRightWallCollision(car)) {
    //        car.setXPosition(700);
    //        collision = true;
    //    }
    //    if (collision){
    //        car.stopEngine();
    //        invertDirection(car);
    //        car.startEngine();
    //    }
    //}

    //private boolean checkLeftWallCollision(MotorVehicle car){
    //    return /*car.getDirection() == Directions.WEST && */car.getXPosition() < 0;
    //}

    //private boolean checkRightWallCollision(MotorVehicle car){
    //    return /*car.getDirection() == Directions.EAST && */car.getXPosition() + 100  > 800;
    //}

    //private boolean checkTopWallCollision(MotorVehicle car){
    //    return /*car.getDirection() == Directions.NORTH && */ car.getYPosition()  < 0;
    //}

    //private boolean checkBottomWallCollision(MotorVehicle car){
    //    return /*car.getDirection() == Directions.SOUTH && */ car.getYPosition() + 60 > 560;
    //}

    //void invertDirection(MotorVehicle car){
    //    car.setDirection(Directions.values()[(car.getDirection().ordinal()+2)%4]);
    //}

}