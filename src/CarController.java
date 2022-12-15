import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the
    // statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    // methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        Saab95 carTwo = new Saab95();
        Scania truck = new Scania();
        carTwo.setY(100);
        truck.setY(200);
        cc.vehicles.add(carTwo);
        cc.vehicles.add(truck);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);
        cc.frame.drawPanel.vehicles = vehicles;
        // Start the timer
        cc.timer.start();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : vehicles) {
                car.move();        
            }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
        }
    }
    

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.gas(gas);
        }
    }

    // Calls the startengine method for each car once
    void startAllCars() {
        for (Vehicle car : vehicles) {
            car.startEngine();
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : vehicles) {
            car.brake(brake);
        }
    }

    /*
    void findTurboCars(){
      for (Vehicle car : cars) {
        if (car instanceof Saab95)
            setTurboOn(car);    
        }
    }
    void setTurboOff(Saab95 car){
        car.setTurboOff();
    }
    void setTurboOn(Saab95 car){
        car.setTurboOn();
    }
    */
}
