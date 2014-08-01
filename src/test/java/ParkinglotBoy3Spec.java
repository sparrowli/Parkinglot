import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class ParkinglotBoy3Spec {
    private ParkinglotBoy3 parkinglotBoy3;

    @Before
    public void setUp() {
        parkinglotBoy3 = new ParkinglotBoy3();
        parkinglotBoy3.addParkinglot();
    }

    @Test
    public void should_park_in_the_parkinglot_Space_with_the_highest_vacancy_rate() {
        Token token12 = parkinglotBoy3.park(new Car("11"));
        Token token13 = parkinglotBoy3.park(new Car("Maserati"));
        Token token14 = parkinglotBoy3.park(new Car("Panamera"));
        Token token24 = parkinglotBoy3.park(new Car("Porsche"));

        assertThat(token12.getParkinglotKey()).isEqualTo(ParkinglotID.Beach);
        assertThat(token13.getParkinglotKey()).isEqualTo(ParkinglotID.Moutain);
        assertThat(token14.getParkinglotKey()).isEqualTo(ParkinglotID.Space);

        assertThat(token24.getParkinglotKey()).isEqualTo(ParkinglotID.Space);
    }

    @Test
    public void should_pick_up_the_car_successfully() {
        Token token12 = parkinglotBoy3.park(new Car("11"));
        Token token13 = parkinglotBoy3.park(new Car("Maserati"));
        Token token14 = parkinglotBoy3.park(new Car("Panamera"));
        Token token24 = parkinglotBoy3.park(new Car("Porsche"));

        Car car = parkinglotBoy3.pickup(token13);
        assertThat(car.getID()).isEqualTo("Maserati");
    }
    @Test
    public void should_not_park_the_car_successfully_if_all_the_parkinglot_is_ful() {
        Token token12 = parkinglotBoy3.park(new Car("11"));
        Token token13 = parkinglotBoy3.park(new Car("Maserati"));
        Token token14 = parkinglotBoy3.park(new Car("Panamera"));
        Token token24 = parkinglotBoy3.park(new Car("Porsche"));
        Token token23 = parkinglotBoy3.park(new Car("32"));
        Token token22 = parkinglotBoy3.park(new Car("22"));
        Token token34 = parkinglotBoy3.park(new Car("34"));
        Token token33 = parkinglotBoy3.park(new Car("33"));
        Token token44 = parkinglotBoy3.park(new Car("44"));

        Token token00 = parkinglotBoy3.park(new Car("00"));


        assertThat(token00).isEqualTo(null);
    }

}
