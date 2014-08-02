import java.util.Map;

public class VacancyRateSelector implements IParkinglotsSelector {
    @Override
    public String parkinglotSelector(Map<String, Parkinglot> parkinglotsMap) {
        String parkinglotID = null;
        double highRateVacancy = 0.0;
        double rateVacancy;

        for (Map.Entry<String, Parkinglot> entry : parkinglotsMap.entrySet()) {
            rateVacancy = entry.getValue().getVacancyRate();
            if (highRateVacancy < rateVacancy) {
                highRateVacancy = rateVacancy;
                parkinglotID = entry.getKey();
            }
        }
        return parkinglotID;
    }
}
