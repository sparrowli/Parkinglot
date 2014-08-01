import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private Map<String, Car> parkingRecord;
    private int parkinglotStatus;
    private int volume;


    public int getParkinglotStatus() {
        return parkinglotStatus;
    }

    public Parkinglot(int volume) {
        this.volume = volume;
        parkinglotStatus = 0;
        parkingRecord = new HashMap<>();
    }

    public boolean isFull() {
        return parkinglotStatus == volume;
    }

    public Token park(Car car) {
        Token token = null;

        if (!isFull()) {
            token = new Token();
            token.setKey(car.getID());
            parkingRecord.put(car.getID(), car);
            parkinglotStatus++;
        }

        return token;
    }

    public Car pickup(Token carTicket) {
        Car car = null;
        if (parkingRecord.containsKey(carTicket.getKey())) {
            car = parkingRecord.get(carTicket.getKey());
            parkingRecord.remove(carTicket.getKey());
            parkinglotStatus--;
        }

        return car;
    }

    public Token compose(Car car) {
        Token token = park(car);
        Car car1 = pickup(token);
        return park(car1);
    }

    public Map<String, Car> getParkingRecord() {
        return parkingRecord;
    }

    public double getVacancyRate() {
        return getRestVolume() / (double)volume;
    }

    public int getRestVolume() {
        return volume - parkinglotStatus;
    }
}
