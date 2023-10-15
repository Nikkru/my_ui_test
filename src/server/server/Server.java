package server.server;

import server.client.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private boolean isServerStart;
    private ServerView serverView;
    private Repository repository;
    private List<Client> clientList;

    public Server(ServerView serverView, Repository repository) {
        this.serverView = serverView;
        this.repository = repository;
        clientList = new ArrayList<>();
    }

    public void start() {
        if (isServerStart){
            showOnWindow("Сервер уже был запущен");
            JOptionPane.showMessageDialog(null, "Server already on");
        } else {
            isServerStart = true;
            showOnWindow("Сервер запущен!");
        }
    }
    private void showOnWindow(String text){
        serverView.showMessage(text + "\n");
    }
}
