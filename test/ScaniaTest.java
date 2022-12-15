import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class ScaniaTest {
Scania testCar = new Scania();

  @Before
  public void reset_car(){
    testCar = new Scania();
  }
  @Test
  public void gas_increases_speed() {
    testCar.startEngine();
    double speed_before_gas = testCar.getCurrentSpeed();
    testCar.gas(1);
    double speed_after_gas = testCar.getCurrentSpeed();

    assertTrue(speed_after_gas > speed_before_gas);
  }
  @Test
  public void brake_decreases_speed(){
    testCar.startEngine();

    double speed_before_brake = 1;
    testCar.gas(1);
    testCar.brake(1);
    double speed_after_brake = testCar.getCurrentSpeed();
    assertTrue(speed_after_brake < speed_before_brake);
  }
  @Test
  public void gas_with_argument_smaller_than_interval_should_throw_error(){
    testCar.startEngine();
    assertThrows(IllegalArgumentException.class, () -> {
        testCar.gas(-1);
    });
  }
    @Test
  public void gas_with_argument_bigger_than_interval_should_throw_error(){
    testCar.startEngine();
    assertThrows(IllegalArgumentException.class, () -> {
        testCar.gas(3);
    });
  }
  @Test
  public void car_can_turn_right_and_move_different_directions_when_engine_on(){
    testCar.turnRight();
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();

    assertTrue(testCar.getY() < testCar.getX());
  }
  @Test
  public void car_can_turn_left_and_move_different_directions_when_engine_on(){
    testCar.turnLeft();
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();

    assertTrue(testCar.getY() > testCar.getX());
  }
  @Test
  public void car_can_not_move_if_engine_is_off(){
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.getY() == testCar.getX());
  }
  @Test
  public void car_can_move_if_engine_is_on(){
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.getY() != testCar.getX());
  }
  @Test
  public void car_can_spin_by_moving_right_4_times(){
    int start_index = testCar.getIndex();
    testCar.startEngine();
    for(int i = 0; i<4; i++){
        testCar.turnRight();
    }
    assertTrue(testCar.getIndex() == start_index);
  }
    @Test
    public void car_can_spin_by_moving_left_4_times(){
    int start_index = testCar.getIndex();
    testCar.startEngine();
    for(int i = 0; i<4; i++){
        testCar.turnLeft();
    }
    assertTrue(testCar.getIndex() == start_index);
  }
    @Test
    public void currentSpeed_does_not_surpass_enginePower(){
      testCar.setCurrentSpeed(testCar.getEnginePower());
      double speed_before_gas = testCar.getCurrentSpeed();
      testCar.gas(1);
      double speed_after_gas = testCar.getCurrentSpeed();
      assertTrue(speed_before_gas == speed_after_gas);
    }
    @Test
    public void currentSpeed_does_not_go_below_zero(){
      testCar.setCurrentSpeed(0);
      double speed_before_brake = testCar.getCurrentSpeed();
      testCar.brake(1);
      double speed_after_brake = testCar.getCurrentSpeed();
      assertTrue(speed_before_brake == speed_after_brake);
}
    @Test
    public void can_move_while_flatbed_not_fastened(){
    testCar.setFlatbedFastened(true);
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.getY() != 0 || testCar.getX() != 0);
    }

    @Test
    public void can_not_move_while_flatbed_not_fastened(){
    testCar.setFlatbedFastened(false);
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.getY() == 0 && testCar.getX() == 0);
    }

    @Test
    public void can_not_move_while_having_raised_flathead(){
    testCar.raiseFlatbed();
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.getY() == 0 && testCar.getX() == 0);
    }
 @Test
    public void can_not_lower_flathead_below_0_degrees(){
    testCar.lowerFlatbed();
    testCar.startEngine();
    testCar.gas(1);
    testCar.move();
    assertTrue(testCar.scaniaFlatbed.getFlatbedAngle() == 0);
    }
@Test
    public void can_not_raise_flathead_while_moving(){
        testCar.startEngine();
        testCar.gas(1);
        testCar.move();
        testCar.raiseFlatbed();
        assertTrue(testCar.scaniaFlatbed.getFlatbedAngle() == 0);
    }
}