package Application;

import java.util.ArrayList;
import Model.*;
import Controller.*;
import View.*;

public class MotorVehicleApplication {
    // dependant upon model, view and controller and should initialize the game.
    public static void main(String[] args) {
        ArrayList<MotorVehicle> vehicles = createBaseVehicles();
        MotorVehicleModel model = createModel(vehicles);



        MotorVehicleController controller = createMotorVehicleController(model);

        MotorVehicleWidgets widgets = createMotorVehicleWidgets(controller, model);

        DrawPanel view = createDrawPanel(vehicles, model);
        MotorVehicleApplicationWindow window = createMotorVehicleApplicationWindow();
        addToWindow(window, view, widgets);
    }

    private static ArrayList<MotorVehicle> createBaseVehicles() {
        ArrayList<MotorVehicle> vehicles = new ArrayList<MotorVehicle>();
        vehicles.add(new Volvo240(0,0));
        vehicles.add(new Saab95(0,100));
        vehicles.add(new Scania(0,200));
        return vehicles;
    }
    private static MotorVehicleModel createModel(ArrayList<MotorVehicle> vehicles) {
        return new MotorVehicleModel(vehicles);
    }
    private static MotorVehicleApplicationWindow createMotorVehicleApplicationWindow() {
        return new MotorVehicleApplicationWindow();
    }
    private static MotorVehicleController createMotorVehicleController(MotorVehicleModel model) {
        return new MotorVehicleController(model);
    }
    private static MotorVehicleWidgets createMotorVehicleWidgets(MotorVehicleController controller, MotorVehicleModel model) {
        return new MotorVehicleWidgets(controller, model.getWorldSizeX(), model.getWorldSizeY()+240);
    }
    private static DrawPanel createDrawPanel(ArrayList<MotorVehicle> vehicles, MotorVehicleModel model) {
        ArrayList<String> modelNames = new ArrayList<String>();
        for ( MotorVehicle vehicle : vehicles) {
            modelNames.add(vehicle.getModelName());
        }
        DrawPanel view = new DrawPanel(model.getWorldSizeX(), model.getWorldSizeY(),modelNames);
        model.addObserver(view);
        return view;
    }
    private static void addToWindow(MotorVehicleApplicationWindow window, DrawPanel view, MotorVehicleWidgets widgets) {
        window.add(view);
        window.add(widgets);
    }
}
