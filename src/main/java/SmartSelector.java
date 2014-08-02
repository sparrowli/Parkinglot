import java.util.Map;

public class SmartSelector implements IParkinglotsSelector {
    @Override
    public String parkinglotSelector(Map<String, Parkinglot> parkinglotsMap) {
        String  parkinglotID = null;
        int restVolume;
        int maxVolume = 0;

        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            restVolume = entry.getValue().getRestVolume();
            if (restVolume > maxVolume) {
                maxVolume = restVolume;
                parkinglotID = entry.getKey();
            }
        }

        return parkinglotID;
    }
}
