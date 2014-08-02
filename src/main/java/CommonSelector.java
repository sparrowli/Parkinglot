import java.util.Map;

public class CommonSelector implements IParkinglotsSelector {

    @Override
    public String parkinglotSelector(Map<String, Parkinglot> parkinglotsMap) {
        String parkinglotID = null;
        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            if (entry.getValue().getRestVolume() > 0) {
                parkinglotID = entry.getKey();
                break;
            }
        }
        return parkinglotID;
    }

}
