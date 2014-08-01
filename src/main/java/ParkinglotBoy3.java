import java.util.HashMap;

public class ParkinglotBoy3 {
    private HashMap<ParkinglotID, Parkinglot> parkinglotsMap;

    public void addParkinglot() {
        parkinglotsMap = new HashMap<>();
        int i = 1;
        for (ParkinglotID id : ParkinglotID.values()) {
            id.setVolume(++i);
            parkinglotsMap.put(id, new Parkinglot(id.getVolume()));
        }

    }

    public Token park(Car car) {
        ParkinglotID parkinglotID = null;
        Token token = null;

        double highRateVacancy = 0.0;
        double rateVacancy = 0.0;

        for (ParkinglotID id : ParkinglotID.values()) {
            rateVacancy = parkinglotsMap.get(id).getVacancyRate();

            if (highRateVacancy < rateVacancy) {
                highRateVacancy = rateVacancy;
                parkinglotID = id;
            }

        }

        if (highRateVacancy != 0) {
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
