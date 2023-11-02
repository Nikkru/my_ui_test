package sem_5.homework;

public class Fork {
//    private String id;
    private boolean areInTheHands;

//    public Fork(String id) {
//        this.id = id;
//    }

    public boolean isAreInTheHands() {
        return areInTheHands;
    }

    public void setAreInTheHands(boolean areInTheHands) {
        this.areInTheHands = areInTheHands;
    }

    public synchronized void free() throws InterruptedException {
        while (isAreInTheHands()) {
            wait();
        }
        setAreInTheHands(true);
    }

    public synchronized void occupied() {
        if (isAreInTheHands()) {
            notify();
        }
        setAreInTheHands(false);
    }
}
