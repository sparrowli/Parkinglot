import java.util.LinkedHashMap;
import java.util.Map;

public class ParkinglotBoy3 {
    private Map<String, Parkinglot> parkinglotsMap;

    public void setParkinglotInfo(Map<String, Integer> parkinglotID2Volume) {
        parkinglotsMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : parkinglotID2Volume.entrySet()) {
            parkinglotsMap.put(entry.getKey(), new Parkinglot(entry.getValue()));
        }

    }

    public Token park(Car car) {
        String parkinglotID = null;
        Token token = null;

        double highRateVacancy = 0.0;
        double rateVacancy = 0.0;

        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            rateVacancy = entry.getValue().getVacancyRate();
            if (highRateVacancy < rateVacancy) {
                highRateVacancy = rateVacancy;
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
