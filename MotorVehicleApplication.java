import java.util.ArrayList;

public class MotorVehicleApplication {
    // dependant upon model, view and controller and should initialize the game.
    public static void main(String[] args) {
        ArrayList<MotorVehicle> vehicles = new ArrayList<MotorVehicle>();
        vehicles.add(new Volvo240(0,0));
        vehicles.add(new Saab95(0,100));
        vehicles.add(new Scania(0,200));
        MotorVehicleModel model = new MotorVehicleModel(vehicles);

        //TODO: Create controller
        MotorVehicleController controller = new MotorVehicleController(model);

        MotorVehicleWidgets widgets = new MotorVehicleWidgets(controller, model.getWorldSizeX(), model.getWorldSizeY()+240);
        //TODO: Create View
        ArrayList<String> modelNames = new ArrayList<String>();
        for ( MotorVehicle vehicle : vehicles) {
            modelNames.add(vehicle.getModelName());
        }
        DrawPanel view = new DrawPanel(model.getWorldSizeX(), model.getWorldSizeY(),modelNames);

        MotorVehicleApplicationWindow window = new MotorVehicleApplicationWindow();
        window.add(view);
        window.add(widgets);

        //MotorVehicleView view = new MotorVehicleView("CarSim 1.0", controller, modelNames);

        // Start a new view and send a reference of self
        // cc.frame = new MotorVehicleView("CarSim 1.0", cc, modelNames);
        //start timer
        // Start the timer
        // cc.timer.start();
    }
}
