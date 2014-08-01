import java.util.HashMap;
import java.util.Map;

public class ParkinglotBoy2 {
    private Map<ParkinglotID, Parkinglot> parkinglotsMap;

    public void setParkinglotInfo() {
        parkinglotsMap = new HashMap<>();
        for (ParkinglotID id : ParkinglotID.values()) {
            id.setVolume(2);
            parkinglotsMap.put(id, new Parkinglot(id.getVolume()));
        }

    }

    public Token park(Car car) {
        ParkinglotID parkinglotID = null;
        Token token = null;

        int restVolume = 0;
        int maxVolume = 0;
       
        for (ParkinglotID id : ParkinglotID.values()) {
            restVolume = parkinglotsMap.get(id).getRestVolume();

            if (restVolume > maxVolume) {
                maxVolume = restVolume;
                parkinglotID = id;
            }

        }

        token = parkinglotsMap.get(parkinglotID).park(car);
        token.setParkinglotKey(parkinglotID);
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
