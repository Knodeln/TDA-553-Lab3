import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;


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

    // The frame that represents frame instance View of the MVC pattern
    CarView frame;

    // A list of cars, modify if needed
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    // methods:
    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on"); 
    JButton turboOffButton = new JButton("Saab Turbo off"); 
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed"); 
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JPanel controlPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JPanel gasPanel = new JPanel();
    JLabel gasLabel = new JLabel("Amount of gas");
    CarController carC;
    int gasAmount = 0;
    int X = 700;
    int Y = 800;

    public static void main(String[] args) {
        // Instance of frame class
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
        cc.initButtons();
    }

    /*
     * Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change frame method to your needs.
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
    public void initButtons(){



        SpinnerModel spinnerModel =
                    new SpinnerNumberModel(0, //initial value
                            0, //min
                            100, //max
                            1);//step
            gasSpinner = new JSpinner(spinnerModel);
            gasSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    gasAmount = (int) ((JSpinner)e.getSource()).getValue();
                }
            });
    
            gasPanel.setLayout(new BorderLayout());
            gasPanel.add(gasLabel, BorderLayout.PAGE_START);
            gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
    
            frame.add(gasPanel);
    
            controlPanel.setLayout(new GridLayout(2,4));
    
            controlPanel.add(gasButton, 0);
            controlPanel.add(turboOnButton, 1);
            controlPanel.add(liftBedButton, 2);
            controlPanel.add(brakeButton, 3);
            controlPanel.add(turboOffButton, 4);
            controlPanel.add(lowerBedButton, 5);
            controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
            controlPanel.setBackground(Color.CYAN);
            frame.add(controlPanel);
    
    
            startButton.setBackground(Color.blue);
            startButton.setForeground(Color.green);
            startButton.setPreferredSize(new Dimension(X/5-15,200));
            frame.add(startButton);
    
    
            stopButton.setBackground(Color.red);
            stopButton.setForeground(Color.black);
            stopButton.setPreferredSize(new Dimension(X/5-15,200));
            frame.add(stopButton);
    
            // This actionListener is for the gas button only
            // TODO: Create more for each component as necessary
            gasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gas(gasAmount);
                }
            });
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    startAllCars();
                }
            });
            brakeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    brake(gasAmount);
                }
            });
}
}