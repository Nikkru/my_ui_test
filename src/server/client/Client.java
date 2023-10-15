package server.client;

import sem2.common.Sprite;
import server.server.Server;
import server.server.ServerWindow;

public class Client {
    private String name;
    private ClientView clientView;
    private Server server;
    private boolean isConnected;

    public Client(ClientView clientView, Server server) {
        this.clientView = clientView;
        this.server = server;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (server.connectUser(this)){
            showOnWindow("Вы успешно подключились!" + System.lineSeparator());
            isConnected = true;
            String log = server.getHistory();
            if (log != null){
                showOnWindow(log);
            }
            return true;
        } else {
            showOnWindow("Подключение не удалось");
            return false;
        }
    }

    public void sendMessage(String message) {
        if (isConnected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            showOnWindow("Нет подключения к серверу!");
        }
    }

    public void serverAnswer(String answer) {
        showOnWindow(answer);
    }

    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            clientView.disconnectFromServer();
            server.disconnectUser(this);
            showOnWindow("Вы были отключены от сервера.");
        }
    }

    public String getName() {
        return name;
    }

    private void showOnWindow(String text) {
        clientView.showMessage(text + System.lineSeparator());
    }
}
