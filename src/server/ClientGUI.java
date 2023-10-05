package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private String[] arrUsers = {"Nick", "Monk", "Sherlok", "Wulf", "1964"};

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private int btnCounter = 0;

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("172.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("Nick");
    private final JTextField tfPassword = new JTextField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    JButton btnSend;
    JList<String> jlistUsers;

    ServerWindow serverWindow;

    ClientGUI() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        serverWindow = new ServerWindow();

        jlistUsers = new JList<>(arrUsers);
        jlistUsers.setLayoutOrientation(JList.VERTICAL);
        JScrollPane tableListUsers = new JScrollPane(jlistUsers);
        tableListUsers.setPreferredSize(new Dimension(100, 20));

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelTop.add(tableListUsers);
        add(panelTop, BorderLayout.NORTH);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(createButtonSend(), BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
    }
    private Component createButtonSend(){
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverWindow.txtLog = tfMessage.getText();
                btnCounter ++;
                System.out.println("Button 'Send' was tapped " + btnCounter + " times");
                serverWindow.repaint();
            }
        });
        return btnSend;
    }
}
