import java.awt.*;

public class Cartransporter extends TruckWithFlatbed{
    Loadable loadedCars;
    FlatbedWithRamp cartransporterFlatbed;

    public Cartransporter(){
        super(2,70, Color.yellow, "Cartransporter");
            loadedCars = new Loadable(6);
            cartransporterFlatbed = new FlatbedWithRamp();
        }
    // public int getAmountOfLoadedCars() {
    //     return loadedCars.size();
    // }

    public void loadCar(Car car){
       loadedCars.loadCar(car,getX(),getY());
    }

    public void unloadLatestCar(){
      loadedCars.unloadLatestCar(getX(),getY());
    }

    public void lowerFlatbed() {
        cartransporterFlatbed.raiseFlatbed(this);
    }

    public void raiseFlatbed() {
       cartransporterFlatbed.raiseFlatbed(this);
    }

}