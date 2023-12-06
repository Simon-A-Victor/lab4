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

        MotorVehicleWidgets widgets = createMotorVehicleWidgets(controller);

        DrawPanel view = createDrawPanel(model);

        MotorVehicleApplicationWindow window = createMotorVehicleApplicationWindow();
        addToWindow(window, view, widgets);
    }

    private static ArrayList<MotorVehicle> createBaseVehicles() {
        ArrayList<MotorVehicle> vehicles = new ArrayList<>();
        vehicles.add(MotorVehicleFactory.createVolvo240(0,0));
        vehicles.add(MotorVehicleFactory.createSaab95(0,100));
        vehicles.add(MotorVehicleFactory.createScania(0,200));
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
    private static MotorVehicleWidgets createMotorVehicleWidgets(MotorVehicleController controller) {
        return new MotorVehicleWidgets(controller, MotorVehicleModel.getWorldSizeX(), MotorVehicleModel.getWorldSizeY()+240);
    }
    private static DrawPanel createDrawPanel(MotorVehicleModel model) {
        DrawPanel view = new DrawPanel(MotorVehicleModel.getWorldSizeX(), MotorVehicleModel.getWorldSizeY());
        model.addObserver(view);
        return view;
    }
    private static void addToWindow(MotorVehicleApplicationWindow window, DrawPanel view, MotorVehicleWidgets widgets) {
        window.add(view);
        window.add(widgets);
    }
}
