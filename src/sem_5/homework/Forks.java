package sem_5.homework;

public class Forks {
    private volatile boolean isInTheHands;

    public boolean isInTheHands() {
        return isInTheHands;
    }

    public void setInTheHands(boolean inTheHands) {
        isInTheHands = inTheHands;
    }
}
