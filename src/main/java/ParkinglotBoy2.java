import java.util.LinkedHashMap;
import java.util.Map;

public class ParkinglotBoy2 {
    private Map<String, Parkinglot> parkinglotsMap;

    public void setParkinglotInfo(Map<String, Integer> parkinglotID2Volume) {
        parkinglotsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : parkinglotID2Volume.entrySet()) {
            parkinglotsMap.put(entry.getKey(), new Parkinglot(entry.getValue()));
        }
    }

    public Token park(Car car) {
        String  parkinglotID = null;
        Token token = null;

        int restVolume;
        int maxVolume = 0;

        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            restVolume = entry.getValue().getRestVolume();
            if (restVolume > maxVolume) {
                maxVolume = restVolume;
                parkinglotID = entry.getKey();
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
