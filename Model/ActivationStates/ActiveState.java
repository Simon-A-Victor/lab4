package Model.ActivationStates;

import Model.Directions;
import Model.MotorVehicle;

public class ActiveState extends ActivationState{
    public ActiveState(MotorVehicle vehicle) {
        super(vehicle);
    }


@Override
    public void onMove(){
        switch (vehicle.getDirection()){
            case NORTH:
                vehicle.setYPosition(vehicle.getYPosition() - vehicle.getCurrentSpeed());
                break;
            case WEST:
                vehicle.setXPosition(vehicle.getXPosition() - vehicle.getCurrentSpeed());
                break;
            case SOUTH:
                vehicle.setYPosition(vehicle.getYPosition() + vehicle.getCurrentSpeed());
                break;
            case EAST:
                vehicle.setXPosition(vehicle.getXPosition() +vehicle.getCurrentSpeed());
                break;
        }
    }

    @Override
    public void onTurnLeft(){
            vehicle.setDirection(Directions.values()[(vehicle.getDirection().ordinal()+3)%4]);
        }

    @Override
    public void onTurnRight(){ vehicle.setDirection(Directions.values()[(vehicle.getDirection().ordinal()+1)%4]);

    }
    @Override
    public void onGas(double amount){
        if (0 <= amount && amount <= 1){
            vehicle.incrementSpeed(amount);
        }
    }

}
