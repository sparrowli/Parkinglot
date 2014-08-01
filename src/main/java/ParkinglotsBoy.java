import java.util.LinkedHashMap;
import java.util.Map;

public class ParkinglotsBoy {
    private Map<String, Parkinglot> parkinglotsMap;

    public void setParkinglotInfo(Map<String, Integer> parkinglotID2Volume) {
        parkinglotsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : parkinglotID2Volume.entrySet()) {
            parkinglotsMap.put(entry.getKey(), new Parkinglot(entry.getValue()));
        }
    }

    public Token park(Car car) {
        Token token = null;
        String parkinglotID = null;
        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            if (entry.getValue().getRestVolume() > 0) {
                parkinglotID = entry.getKey();
                break;
            }
        }

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
