import java.util.HashMap;
import java.util.Map;

public class ParkinglotsBoy {
    private Map<ParkinglotID, Parkinglot> parkinglotsMap;

    public ParkinglotsBoy() {
        parkinglotsMap = new HashMap<>();
        for (ParkinglotID id : ParkinglotID.values()) {
            parkinglotsMap.put(id, new Parkinglot(id.getVolume()));
        }
    }

    public Token park(Car car) {
        Token token = null;

        Boolean isFull = parkinglotsMap.get(ParkinglotID.Space).isFull();
        if (!isFull) {
            for (ParkinglotID id : ParkinglotID.values()) {

                token = parkinglotsMap.get(id).park(car);

                if (token != null) {
                    token.setParkinglotKey(id);
                    break;
                }
            }
        }

        return token;
    }

    public Car pickup(Token token) {
        if (parkinglotsMap.containsKey(token.getParkinglotKey())) {
            return parkinglotsMap.get(token.getParkinglotKey()).pickup(token);
        } else {
            return null;
        }
    }
}
