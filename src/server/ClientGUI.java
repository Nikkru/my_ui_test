package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientGUI extends JFrame {
    private static final String[] arrUsers = {"Nick", "Monk", "Sherlok", "Wulf", "1964"};

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private int btnCounter = 0;

    public static String logPath;

//    private final JPanel panelBottom = new JPanel(new BorderLayout());
//    private JTextField tfMessage = new JTextField();

    private ServerWindow serverWindow;
    private boolean isConnected;
    private String name;

    JTextArea log;
    JButton btnSend, btnLogin;
    JList<String> jlistUsers;
    JPanel headerPanel;
    JTextField tfMessage, tfIPAddress, tfPort, tfLogin;
    JPasswordField passwordField;

    ClientGUI(ServerWindow serverWindow) {
        this.serverWindow = serverWindow;

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        logPath = ServerWindow.LOG_PATH;
        jlistUsers = new JList<>(arrUsers);
        jlistUsers.setLayoutOrientation(JList.VERTICAL);
        JScrollPane tableListUsers = new JScrollPane(jlistUsers);
        tableListUsers.setPreferredSize(new Dimension(100, 20));

        createPanel();

        setVisible(true);
    }

    private void createPanel() {
        add(createHeaderPanel(), BorderLayout.NORTH);
        add(createTextAreaLog());
        add(createFooter(), BorderLayout.SOUTH);
    }

    private Component createHeaderPanel(){
        headerPanel = new JPanel(new GridLayout(2, 3));
        tfIPAddress = new JTextField("127.0.0.1");
        tfPort = new JTextField("8189");
        tfLogin = new JTextField("Nick");
        passwordField = new JPasswordField("123456");
        btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        headerPanel.add(tfIPAddress);
        headerPanel.add(tfPort);
        headerPanel.add(new JPanel());
        headerPanel.add(tfLogin);
        headerPanel.add(passwordField);
        headerPanel.add(btnLogin);

        return headerPanel;
    }
    public void answer(String text) { appendLog(text); }

    private void appendLog(String text) { log.append(text + System.lineSeparator()); }

    private void connectToServer() {
        if (serverWindow.connectUser(this)) {
            appendLog("Вы успешно подключились!" + System.lineSeparator());
            headerPanel.setVisible(false);
            name = tfLogin.getText();
            String log = serverWindow.getLog();
            isConnected = true;
            if (log != null) {
                appendLog(log);
            }
        } else {
            appendLog("Connect falls");
        }
    }

    private void disconnectFromServer() {
        if (isConnected) {
            headerPanel.setVisible(true);
            isConnected = false;
            serverWindow.disconnectUser(this);
            appendLog("Вы успешно отключены от сервера!");
        }
    }

    public void message() {
        if (isConnected) {
            String text = tfMessage.getText();
            if (!text.equals("")) {
                serverWindow.sendMessage(name + ": " + text);
                tfMessage.setText("");
            }
        } else {
            appendLog("Нет подключения к верверу.");
        }
    }

    private Component createTextAreaLog() {
        log = new JTextArea();
        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        JScrollPane scrollLog = new JScrollPane(log);
        return scrollLog;
    }

    private Component createFooter() {
        JPanel jPanel = new JPanel(new BorderLayout());
        tfMessage = new JTextField();
        tfMessage.addKeyListener(new KeyAdapter() { // вызов метода по клавиатуре
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    message();
                }
            }
        });
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });
        jPanel.add(tfMessage);
        jPanel.add(btnSend, BorderLayout.EAST);
        return  jPanel;
    }
/*
    private Component createButtonSend(){
        btnSend = new JButton("Send");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log.append(tfMessage.getText() + System.lineSeparator());

                try(FileWriter writer = new FileWriter(logPath, true)) {

                    String text = tfMessage.getText();
                    writer.write(text + System.lineSeparator());

                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
                }

                btnCounter ++;
                System.out.println("Button 'Send' was tapped " + btnCounter + " times");
//                serverWindow.repaint();
                tfMessage.setText("");
            }
        });
        return btnSend;
    }
*/
    @Override
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            disconnectFromServer();
        }
    }
}
