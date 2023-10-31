package sem_5.ex1;

public class Friend {
    private String name;

    public String getName() {
        return name;
    }

    public Friend(String name) {
        this.name = name;
    }

    public synchronized void bow(Friend friend) {
        System.out.println(name + ": " + friend.getName() + " bow to " + name + ".");
        friend.bowBack(friend);
    }

    public synchronized void bowBack(Friend friend) {
        System.out.println(name + ": bow back to " + friend.getName());
    }
}
