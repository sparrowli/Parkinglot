import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class ParkinglotBoy2Spec {
    private ParkinglotsBoy smartBoy;
    @Before
    public void setUp() {
        smartBoy = new ParkinglotsBoy(new SmartSelector());
        Map<String, Integer> parkinglotID2Volume = new LinkedHashMap<>();
        parkinglotID2Volume.put("Beach", 2);
        parkinglotID2Volume.put("Moutain", 2);
        parkinglotID2Volume.put("Space", 2);
        smartBoy.setParkinglotInfo(parkinglotID2Volume);
    }

    @Test
    public void should_park_the_car_in_the_first_if_all_parkinglot_volume_is_same() {
        Token token = smartBoy.park(new Car("hello"));
        System.out.println(token.getParkinglotKey());
        assertThat(token.getParkinglotKey()).isEqualTo("Beach");
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
        assertThat(token1.getParkinglotKey()).isEqualTo("Moutain");
    }
    

    @Test
    public void should_park_the_car_in_the_biggest_volume_of_the_rest_parkinglot() {
        Token token1 = smartBoy.park(new Car("1"));
        Token token2 = smartBoy.park(new Car("2"));
        Token token3 = smartBoy.park(new Car("3"));

        assertThat(token3.getParkinglotKey()).isEqualTo("Space");
    }

    @Test
    public void should_not_park_the_car_if_all_parkinglot_is_ful() {
        Token token11 = smartBoy.park(new Car("11"));
        Token token12 = smartBoy.park(new Car("12"));
        Token token13 = smartBoy.park(new Car("13"));
        Token token21 = smartBoy.park(new Car("21"));
        Token token22 = smartBoy.park(new Car("32"));
        Token token23 = smartBoy.park(new Car("22"));

        Token token00 = smartBoy.park(new Car("00"));
        assertThat(token00).isEqualTo(null);
    }
}
