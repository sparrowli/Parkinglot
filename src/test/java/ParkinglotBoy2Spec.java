import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParkinglotBoy2Spec {
    private ParkinglotBoy2 smartBoy;
    @Before
    public void setUp() {
        smartBoy = new ParkinglotBoy2();
        smartBoy.setParkinglotInfo();
    }

    @Test
    public void should_park_the_car_in_the_first_if_all_parkinglot_volume_is_same() {
        Token token = smartBoy.park(new Car("hello"));
        System.out.println(token.getParkinglotKey());
        assertThat(token.getParkinglotKey()).isEqualTo(ParkinglotID.Beach);
    }

    @Test
    public void should_pick_up_successfully() {
        Token token = smartBoy.park(new Car("hello"));
        Car car = smartBoy.pickup(token);
        assertThat(car.getID()).isEqualTo("hello");
    }

    @Test
    public void should_park_the_car_in_the_second_if_the_volume_of_rest_parkinglog_is_same() {
        Token token0 = smartBoy.park(new Car("Ford"));
        Token token1 = smartBoy.park(new Car("panamera"));
        assertThat(token1.getParkinglotKey()).isEqualTo(ParkinglotID.Moutain);
    }
    

    @Test
    public void should_park_the_car_in_the_biggest_volume_of_the_rest_parkinglot() {
        Token token1 = smartBoy.park(new Car("1"));
        Token token2 = smartBoy.park(new Car("2"));
        Token token3 = smartBoy.park(new Car("3"));

        assertThat(token3.getParkinglotKey()).isEqualTo(ParkinglotID.Space);
    }
}
