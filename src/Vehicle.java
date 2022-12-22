import java.awt.*;

abstract class Vehicle implements Movable{
    private int nrDoors;
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private String modelName;
    private Point position;
   

    protected boolean isEngineOn;

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
        this.position = new Point();
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

    public double speedFactor(){
        return enginePower * 0.01;
    }
    public void startEngine(){
	    this.isEngineOn = true;
    }
    public void stopEngine(){
        this.isEngineOn = false;
    }
    
    private void incrementSpeed(double amount){
        this.currentSpeed = this.getCurrentSpeed() + this.speedFactor() * amount;
        if (this.currentSpeed > this.getEnginePower()){
            this.currentSpeed = this.getEnginePower();
        }
    }

    private void decrementSpeed(double amount){
        this.currentSpeed = this.getCurrentSpeed() - this.speedFactor() * amount;
        if (this.currentSpeed < 0){
            this.currentSpeed = 0;
        }
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount <= 1 && amount >= 0 && isEngineOn()){
            this.incrementSpeed(amount);
        }
        else if (isEngineOn()){
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

    public int getX() {
        return this.position.x;
    }
    public int getY() {
        return this.position.y;
    }
    public void setX(int x) {
        this.position.x = x;
    }
    public void setY(int y) {
        this.position.y = y;
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
        int new_x = getX() + (int) Math.round(currentSpeed) * directionList[index][0];
        this.setX(new_x);
        int new_y = getY() + (int) Math.round(currentSpeed) * directionList[index][1];
        this.setY(new_y);
        }
    }
}
