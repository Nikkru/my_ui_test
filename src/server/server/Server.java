package server.server;

import server.client.Client;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final static String MESSAGE_SERVER_ON = "Сервер включен";
    private final static String MESSAGE_SERVER_ON_ALREADY = "Сервер уже включен";
    private final static String MESSAGE_SERVER_DOWN = "Сервер выключен";
    private final static String MESSAGE_SERVER_DOWN_ALREADY = "Сервер уже выключен";

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
        if (isServerStart) {
            showOnWindow(MESSAGE_SERVER_ON_ALREADY);
            showMessageDialog(MESSAGE_SERVER_ON_ALREADY);
        } else {
            isServerStart = true;
            showOnWindow(MESSAGE_SERVER_ON);
            showMessageDialog(MESSAGE_SERVER_ON);
        }
    }

    public void stop() {
        if (!isServerStart) {
            showOnWindow(MESSAGE_SERVER_DOWN_ALREADY);
            showMessageDialog(MESSAGE_SERVER_DOWN_ALREADY);
        } else {
            isServerStart = false;
            showOnWindow(MESSAGE_SERVER_DOWN);
            showMessageDialog(MESSAGE_SERVER_DOWN);
        }
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
            showOnWindow(client.getName() + " отключился от беседы");
        }
    }

    public boolean connectUser(Client client) {
        if (!isServerStart){
            return false;
        }
        clientList.add(client);
        showOnWindow(client.getName() + " подключился к беседе");
        return true;
    }

    public void sendMessage(String text) {
        if (!isServerStart){
            return;
        }
        text += "";
        showOnWindow(text);
        answerAll(text);
        saveInLog(text);
    }

    public String getHistory() {
        return (String) repository.load();
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    private void saveInLog(String text){
        repository.save(text);
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void showOnWindow(String text){
        serverView.showMessage(text + "\n");
    }
}
