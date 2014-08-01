public enum ParkinglotID {
    Beach(1), Moutain(1), Space(2);

    private int volume;

    ParkinglotID(int volume) {
        this.volume = volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
}