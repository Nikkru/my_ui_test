package interfaces;

public class Game {
    public Player player;
    Boy Ivan = new Boy();
    Girl Masha = new Girl();

    public Game() {
        start(Ivan);
        start(Masha);
    }

    void start(Player player) {
        player.play();
    }

}
