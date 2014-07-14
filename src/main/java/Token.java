public class Token {
    private String key;

    private ParkinglotID parkinglotKey;

    public void setParkinglotKey(ParkinglotID parkinglotKey) {
        this.parkinglotKey = parkinglotKey;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public ParkinglotID getParkinglotKey() {
        return parkinglotKey;
    }
}
