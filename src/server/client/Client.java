package server.client;

import sem2.common.Sprite;
import server.server.ServerWindow;

public class Client {
    private String name;
    private ClientView clientView;
    private ServerWindow serverWindow;
    private boolean isConnected;

    public Client(ClientView clientView, ServerWindow serverWindow) {
        this.clientView = clientView;
        this.serverWindow = serverWindow;
    }

    public boolean connectToServer(String name) {
        this.name = name;
        if (serverWindow.connectUser(this)) {
            printText("Вы успешно подключились!" + System.lineSeparator());
            String log = serverWindow.getLog();
            isConnected = true;
            if (log != null) {
                printText(log);
            }
        } else {
            printText("Connect falls");
            return false;
        }
        return true;
    }

    public void sendMessage(String message) {
        if (isConnected) {
            if (!message.isEmpty()) {
                serverWindow.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу!");
        }
    }

    public void serverAnswer(String answer) {
        printText(answer);
    }

    public void disconnect() {

        if (isConnected) {
            isConnected = false;
            clientView.disconnectFromServer();
            serverWindow.disconnectUser(this);
            printText("Вы были отключены от сервера.");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text) {
        clientView.showMessage(text);
    }
}
