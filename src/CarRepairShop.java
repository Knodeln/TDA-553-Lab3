import java.awt.*;

public class CarRepairShop {
  Loadable loadedCars;
private Point position;

  public CarRepairShop(double xPos, double yPos) {
    position = new Point();
    loadedCars = new Loadable(6);
  }
  

  // public int getAmountOfLoadedCars() {
  // return loadedCars.size();
  // }

  public int getX() {
    return position.x;
  }

  public int getY() {
    return position.y;
  }

  public void loadCar(Car car) {
    loadedCars.loadCar(car, getX(), getY());
  }

  public void unloadLatestCar() {
    loadedCars.unloadLatestCar(getX(), getY());
  }
}