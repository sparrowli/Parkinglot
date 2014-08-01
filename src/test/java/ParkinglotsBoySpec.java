import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class ParkinglotsBoySpec {
    private ParkinglotsBoy parkinglotsBoy;

    @Before
    public void setUp() {
        parkinglotsBoy = new ParkinglotsBoy();
        Map<String, Integer> parkinglotID2Volume = new LinkedHashMap<>();
        parkinglotID2Volume.put("Beach", 1);
        parkinglotID2Volume.put("Moutain", 1);
        parkinglotID2Volume.put("Space", 2);

        parkinglotsBoy.setParkinglotInfo(parkinglotID2Volume);
    }

    @Test
    public void should_park_in_the_first_parkinglot_if_it_is_not_ful() {
        Token token = parkinglotsBoy.park(new Car("Panamera"));
        assertThat(token.getParkinglotKey()).isEqualTo("Beach");
    }

    @Test
    public void should_park_in_the_second_parkinglot_if_the_first_is_ful() {
        Token token1 = parkinglotsBoy.park(new Car("sasd"));
        Token token2 = parkinglotsBoy.park(new Car("Panamera"));
        assertThat(token2.getParkinglotKey()).isEqualTo("Moutain");
    }

    @Test
    public void should_park_in_the_third_parkinglot_if_the_first_and_second_is_ful() {
        Token token1 = parkinglotsBoy.park(new Car("sasd"));
        Token token2 = parkinglotsBoy.park(new Car("Panamera"));
        Token token3 = parkinglotsBoy.park(new Car("Maserati"));
        assertThat(token3.getParkinglotKey()).isEqualTo("Space");
    }

    @Test
    public void should_not_park_successfully_when_parkinglot_is_ful() {
        Token token0 = parkinglotsBoy.park(new Car("panamera"));
        Token token1 = parkinglotsBoy.park(new Car("Maserati"));
        Token token2 = parkinglotsBoy.park(new Car("Ford"));
        Token token3 = parkinglotsBoy.park(new Car("BTW"));

        Token token = parkinglotsBoy.park(new Car());
        assertThat(token).isEqualTo(null);
    }

    @Test
    public void should_pickup_the_parking_car_successfully() {
        Token token0 = parkinglotsBoy.park(new Car("panamera"));
        Token token1 = parkinglotsBoy.park(new Car("Marsharidia"));
        Token token2 = parkinglotsBoy.park(new Car("Ford"));

        Car car0 = parkinglotsBoy.pickup(token0);
        Car car1 = parkinglotsBoy.pickup(token1);
        Car car2 = parkinglotsBoy.pickup(token2);

        assertThat(car0.getID()).isEqualTo("panamera");
        assertThat(car1.getID()).isEqualTo("Marsharidia");
        assertThat(car2.getID()).isEqualTo("Ford");
    }

    @Test
    public void should_not_pickup_car_successfully_when_token_is_invalid() {
        Token token = new Token();

        Car car = parkinglotsBoy.pickup(token);

        assertThat(car).isEqualTo(null);
    }
}
