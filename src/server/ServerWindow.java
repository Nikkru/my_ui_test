package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {

    TextAreaServer textAreaServer;
//    JTextArea text1;

    private static final int WIDTH = 555;
    private static final int HEIGHT = 507;
    private static final String MSG_IS_ON = "Сервер уже включен!";
    private static final String MSG_IS_OUT = "Сервер уже выключен!";

    private JButton btnStart, btnStop;
    private boolean isServerWorking;

    ServerWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Server Chat");
        setResizable(false);

        textAreaServer = new TextAreaServer();
//        text1 = new JTextArea("", 10, 15);

        isServerWorking = false;
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    btnIsPushed(isServerWorking);
                } else {
                    isServerWorking = true;
                    System.out.println("Server started " + isServerWorking);
                }
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    btnIsPushed(isServerWorking);
                } else {
                    isServerWorking = false;
                    System.out.println("Server stoped " + isServerWorking);
                }
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(panBottom, BorderLayout.CENTER);

        setVisible(true);
    }
    void btnIsPushed(boolean isOn) {
        if (isOn) {
//            msg();
            JOptionPane.showMessageDialog(null, MSG_IS_ON);
            System.out.println("Server already on");
        } else {
            JOptionPane.showMessageDialog(null, MSG_IS_OUT);
//            msg();
            System.out.println("Server already out");
        }
    }

    private void msg() {
        textAreaServer.msgServer(isServerWorking);
    }

}
