import java.util.HashMap;
import java.util.Map;

public class Parkinglot {
    private Map<String, Car> parkingRecord;
    private int parkinglotStatus;
    private int volume;


    public Parkinglot(int volume) {
        this.volume = volume;
        parkinglotStatus = 0;
        parkingRecord = new HashMap<>();
    }

    public boolean isFull() {
        boolean isFull;

        isFull = (parkinglotStatus == volume);
        if (isFull) {
            return true;
        }
        return false;
    }

    public Token park(Car car) {
        if (isFull()) return null;

        Token token = new Token();
        token.setKey(car.getID());
        parkingRecord.put(car.getID(), car);
        parkinglotStatus++;
        return token;
    }

    public Car pickup(Token carTicket) {
        Car car;
        if (parkingRecord.containsKey(carTicket.getKey())) {

            parkinglotStatus--;
            car = parkingRecord.get(carTicket.getKey());
            parkingRecord.remove(carTicket.getKey());
        } else {
            return null;
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

    public int getStatus() {
        return parkinglotStatus;
    }
}
