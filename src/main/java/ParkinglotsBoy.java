import java.util.LinkedHashMap;
import java.util.Map;

public class ParkinglotsBoy {
    private Map<String, Parkinglot> parkinglotsMap;
    private IParkinglotsSelector selector;

    public ParkinglotsBoy(IParkinglotsSelector selector) {
        this.selector = selector;
    }

    public void setParkinglotInfo(Map<String, Integer> parkinglotID2Volume) {
        parkinglotsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : parkinglotID2Volume.entrySet()) {
            parkinglotsMap.put(entry.getKey(), new Parkinglot(entry.getValue()));
        }
    }

    public Token park(Car car) {
        Token token = null;
        String parkinglotID = null;
        parkinglotID = selector.parkinglotSelector(parkinglotsMap);

        if (parkinglotID != null) {
            token = parkinglotsMap.get(parkinglotID).park(car);
            token.setParkinglotKey(parkinglotID);
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
