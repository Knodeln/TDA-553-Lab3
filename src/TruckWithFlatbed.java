import java.awt.*;

abstract class TruckWithFlatbed extends Truck {
    private boolean flatbedFastened;

    public boolean isFlatbedFastened() {
        return flatbedFastened;
    }

    public TruckWithFlatbed(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors, enginePower, color, modelName);
        flatbedFastened = true;
    }

    @Override
    public void startEngine() {
        if (flatbedFastened) {
            isEngineOn = true;
        }
    }
    

    public void setFlatbedFastened(boolean inBoolean) {
        flatbedFastened = inBoolean;
    }
}
