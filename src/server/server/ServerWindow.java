package server.server;

import server.TextAreaServer;
import server.client.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {

    TextAreaServer textAreaServer;
//    ClientGUI clientGUI;
    List<Client> clientList;
//
    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final String MSG_IS_ON = "Сервер уже включен!";
    private static final String MSG_IS_OUT = "Сервер уже выключен!";
    public static final String LOG_PATH = "log.txt";

//    private JTextField tfLog = new JTextField();

    JButton btnStart, btnStop;
    boolean isServerWorking;
    JTextArea log;

    public ServerWindow() {
        clientList = new ArrayList<Client>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server Chat");
        setResizable(false);


//        clientGUI = new ClientGUI(this);
        textAreaServer = new TextAreaServer();

//        isServerWorking = false;
//        btnStart = new JButton("Start");
//        btnStop = new JButton("Stop");
//
//        btnStart.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (isServerWorking) {
//                    btnIsPushed(isServerWorking);
//                } else {
//                    isServerWorking = true;
//                    System.out.println("Server started " + isServerWorking);
//
//                }
//                clientGUI.setVisible(true);
//            }
//        });

//        btnStop.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!isServerWorking) {
//                    btnIsPushed(isServerWorking);
//                } else {
//                    isServerWorking = false;
//                    System.out.println("Server stoped " + isServerWorking);
//                    for (ClientGUI clientGUI: clientGUIList) {
//                        disconnectUser(clientGUI);
//                    }
//                    appendLog("Server shut down");
//                }
//                clientGUI.setVisible(false);
//            }
//        });
//
//        JPanel panBottom = new JPanel(new GridLayout(1, 2));
//        JPanel panCenter = new JPanel(new GridLayout(1, 1));
//
//        panBottom.add(btnStart);
//        panBottom.add(btnStop);
//        panCenter.add(log);

//        add(panBottom, BorderLayout.SOUTH);
//        add(panCenter, BorderLayout.CENTER);

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    public boolean connectUser(Client client) {
        if (!isServerWorking) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    private void writeLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH)) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLog() {
        return readLog();
    }

    public boolean addUserToChatList(Client clientGUI) {
        if (!isServerWorking) {
            return false;
        }
        clientList.add(clientGUI);
        return true;
    }

    public void disconnectUser(Client clientGUI) {
        if (isServerWorking) {
            if (clientGUI != null) {
                clientList.remove(clientGUI);
                System.out.println("Пользователь отключен");
            }
        }
    }

    private void appendLog(String text){
        log.append(text + System.lineSeparator());
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

    public void sendMessage(String text){
        if (!isServerWorking){
            return;
        }
        text += "";
        appendLog(text);
        answerAll(text);
        writeLog(text);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking){
                    appendLog("Сервер уже был запущен");
                } else {
                    isServerWorking = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking){
                    appendLog("Сервер уже был остановлен");
                } else {
                    isServerWorking = false;
//                    for (int i = clientGUIList.size(); i > 0; i-- ) {
//                        disconnectUser(clientGUIList[i]);
//                    }
                    for (Client clientGUI: clientList) {
                        disconnectUser(clientGUI);
                    }
                    //TODO поправить удаление
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

    void btnIsPushed(boolean isOn) {
        if (isOn) {
            JOptionPane.showMessageDialog(null, MSG_IS_ON);
            System.out.println("Server already on");
        } else {
            JOptionPane.showMessageDialog(null, MSG_IS_OUT);
            System.out.println("Server already out");
        }
    }
}
