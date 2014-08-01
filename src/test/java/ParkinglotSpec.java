import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParkinglotSpec {
    private Parkinglot parkinglot;

    @Before
    public void setUp() {
        parkinglot = new Parkinglot(2);
    }

    @Test
    public void should_park_successfully() {
        Token carTicket = parkinglot.park(new Car("Ford"));
        assertThat(carTicket.getKey()).isEqualTo("Ford");
    }

    @Test
    public void should_park_continuous_successfully() {
        Token carTicket0 = parkinglot.park(new Car("Ford"));
        Token carTicket1 = parkinglot.park(new Car("porsche"));
        assertThat(carTicket1.getKey()).isEqualTo("porsche");
        assertThat(carTicket0.getKey()).isEqualTo("Ford");
    }

    @Test
    public void should_park_failure_when_parkinglot_is_ful() {
        Token Ticket1 = parkinglot.park(new Car());
        Token Ticket2 = parkinglot.park(new Car());
        Token nonTicket = parkinglot.park(new Car());
        assertThat(nonTicket).isEqualTo(null);
    }

    @Test
    public void should_pickup_the_car_with_token_successfully() {
        Token carTicket = parkinglot.park(new Car("panamera"));
        Car car = parkinglot.pickup(carTicket);
        assertThat(car.getID()).isEqualTo("panamera");
    }

    @Test
    public void should_not_pickup_the_car_if_car_not_in_the_parkinglot_successfully() {
        Token token = new Token();
        Car car = parkinglot.pickup(token);
        assertThat(car).isEqualTo(null);
    }

    @Test
    public void should_park_again_successfuly() {
        Token token = parkinglot.compose(new Car("Paramena"));
        assertThat(token.getKey()).isEqualTo("Paramena");
    }
}

