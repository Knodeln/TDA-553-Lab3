import java.util.*;


public class Loadable {
    private int capacity;
    ArrayList<Car> loadedCars;
    private final int reasonableDistance;
    public Loadable(int nr){
        capacity = nr;
        loadedCars = new ArrayList<Car>();
        reasonableDistance = 5;
    }
    public int getAmountOfLoadedCars() {
        return loadedCars.size();
    }

    public void loadCar(Car car, double xPos, double yPos){
        if(loadedCars.size() < capacity && distanceToCar(car, xPos, yPos) < reasonableDistance){
            loadedCars.add(car);
            }
        }
        

    public void unloadLatestCar(int xPos, int yPos){
        if(loadedCars.size() > 0){
            Car carToUnload = loadedCars.get(loadedCars.size() - 1);
            int index = loadedCars.size() - 1;
            loadedCars.remove(index);
            carToUnload.setY(yPos+reasonableDistance);
            carToUnload.setX(xPos+reasonableDistance);
        }
    }

    public double distanceToCar(Car car, double xPos, double yPos){
        double yDiff = Math.pow(Math.abs(yPos - car.getY()),2);
        double xDiff = Math.pow(Math.abs(xPos - car.getX()),2);
        double dist = Math.sqrt(xDiff+yDiff);
        return dist;
    }

    
}
