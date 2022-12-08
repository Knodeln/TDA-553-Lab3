import java.awt.*;


abstract class Vehicle implements Movable{
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
   

    private boolean isEngineOn;
    private double x;
    private double y;

    private int[][] directionList = {{0,1},{1,0},{0,-1},{-1,0}};
    private int index = 0;
    

    public int getIndex() {
        return index;
    }
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.isEngineOn = false;
        this.x = 0;
        this.y = 0;
    }
    public boolean isEngineOn() {
        return isEngineOn;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public String getModelName() {
        return modelName;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }
    public void setCurrentSpeed(double newSpeed) {
        if (newSpeed <= enginePower && newSpeed >= 0)
        this.currentSpeed = newSpeed;
    }
    public double speedFactor(){
        return enginePower * 0.01;
    }
    public void startEngine(){
	    this.isEngineOn = true;
    }
    public void stopEngine(){
        this.isEngineOn = false;
    }
    
    public void incrementSpeed(double amount){
        this.currentSpeed = this.getCurrentSpeed() + this.speedFactor() * amount;
        if (this.currentSpeed > this.getEnginePower()){
            this.currentSpeed = this.getEnginePower();
        }
    }

    public void decrementSpeed(double amount){
        this.currentSpeed = this.getCurrentSpeed() - this.speedFactor() * amount;
        if (this.currentSpeed < 0){
            this.currentSpeed = 0;
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount <= 1 && amount >= 0 && isEngineOn){
            this.incrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("Amount should be in the range 0-1.");
        }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount <= 1 && amount >= 0){
            this.decrementSpeed(amount);
        }
        else{
            throw new IllegalArgumentException("Amount should be in the range 0-1.");
        }
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }


    public void turnLeft(){
        index -= 1;
        if (index < 0){
            index = 3;
        }
    }

    public void turnRight(){
        index += 1;
        if (index > 3){
            index = 0;
        }
    }

    public void move(){
        if(this.isEngineOn() == true){
        double new_x = getX() + currentSpeed * directionList[index][0];
        this.setX(new_x);
        double new_y = getY() + currentSpeed * directionList[index][1];
        this.setY(new_y);
        }
    }
}





